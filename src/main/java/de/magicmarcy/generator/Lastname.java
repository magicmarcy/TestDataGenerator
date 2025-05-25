package de.magicmarcy.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.enums.CountryCode;
import de.magicmarcy.exceptions.FileContentLoadingException;
import de.magicmarcy.exceptions.ResourceNotFoundException;

/**
 * Creates random last names. <br/>
 * Use {@code Lastname.builder()} to get a builder.
 * <br/>
 * Example:
 * <pre>{@code
 * List<String> names = Lastname.builder()
 *     .count(10)
 *     .build();
 * }</pre>
 * or
 * <pre>{@code
 *   final String name = Lastname.builder().buildOne();
 * }</pre>
 *
 * @author magicmarcy
 */
public final class Lastname {

  /** Default number of results to generate */
  private static final int DEFAULT_COUNT = 1;

  /**
   * Default constructor to prevent instantiation.
   */
  private Lastname() {
    // Prevent instantiation
  }

  /**
   * Creates a new builder for generating last names.
   *
   * @return a new instance of {@link LastnameBuilder}
   */
  public static LastnameBuilder builder() {
    return new LastnameBuilder();
  }

  /**
   * Builder class for generating last names.
   */
  public static class LastnameBuilder {
    private int count = DEFAULT_COUNT;
    private CountryCode countryCode = null;

    /**
     * Sets the number of last names to generate.
     *
     * @param count the number of last names
     * @return this builder
     */
    public LastnameBuilder count(final int count) {
      this.count = count;
      return this;
    }

    /**
     * Sets the country of last names to generate.
     *
     * @param countryCode the country for the last names
     * @return this builder
     */
    public LastnameBuilder country(final CountryCode countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Generates a random last name.
     *
     * @return a random last name
     */
    public String buildOne() {
      return buildList().get(0);
    }

    /**
     * Generates a list of random last names. If the countrycode was not set there will be a random name chosen from all available countries.
     *
     * @return a list of random last names
     */
    public List<String> buildList() {
      final List<String> sourceNames = new ArrayList<>();

      if (this.countryCode == null) {
        for (final CountryCode country : CountryCode.values()) {
          sourceNames.addAll(loadNames("files/" + country.getFoldername() + "/lastnames.txt"));
        }
      } else {
        sourceNames.addAll(loadNames("files/" + this.countryCode.getFoldername() + "/lastnames.txt"));
      }

      final List<String> result = new ArrayList<>();

      for (int i = 0; i < this.count; i++) {
        result.add(getRandom(sourceNames));
      }

      return result;
    }

    /**
     * Loads names from the specified file.
     *
     * @param path the path to the file
     * @return a list of names
     */
    private static List<String> loadNames(final String path) {
      try (final InputStream is = Lastname.class.getClassLoader().getResourceAsStream(path)) {
        if (is == null) {
          throw new ResourceNotFoundException("File not found: " + path);
        }

        return new BufferedReader(new InputStreamReader(is))
            .lines()
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .toList();

      } catch (final IOException e) {
        throw new FileContentLoadingException("Error loading names", e);
      }
    }

    /**
     * Returns a random element from the provided list.
     *
     * @param list the list to choose from
     * @return a random element from the list
     */
    private static String getRandom(final List<String> list) {
      return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
  }
}
