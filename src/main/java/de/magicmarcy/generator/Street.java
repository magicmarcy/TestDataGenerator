package de.magicmarcy.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.enums.CountryCode;
import de.magicmarcy.exceptions.NameLoadingException;
import de.magicmarcy.exceptions.ResourceNotFoundException;

public class Street {

  /** Default number of results to generate */
  private static final int DEFAULT_COUNT = 1;

  /** Path to the streetnames file */
  private static final String STREETNAMES_FILE = "files/de/streetnames_de.txt";

  /**
   * Default constructor to prevent instantiation.
   */
  private Street() {
    // Prevent instantiation
  }

  /**
   * Creates a new builder for generating street names.
   *
   * @return a new instance of {@link de.magicmarcy.generator.Street.StreetBuilder}
   */
  public static StreetBuilder builder() {
    return new StreetBuilder();
  }

  /**
   * Builder class for generating street names.
   */
  public static class StreetBuilder {
    private int count = DEFAULT_COUNT;
    private CountryCode countryCode = null;

    /**
     * Sets the number of street names to generate.
     *
     * @param count the number of street names
     * @return this builder
     */
    public StreetBuilder count(final int count) {
      this.count = count;
      return this;
    }

    /**
     * Sets the country of street names to generate.
     *
     * @param countryCode the country for the street names
     * @return this builder
     */
    public StreetBuilder country(final CountryCode countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Generates a random street name.
     *
     * @return a random street name
     */
    public String buildOne() {
      return buildList().get(0);
    }

    /**
     * Generates a list of random street names.
     *
     * @return a list of random street names
     */
    public List<String> buildList() {
      final List<String> sourceNames = new ArrayList<>(loadStreets(STREETNAMES_FILE));
      final List<String> result = new ArrayList<>();

      for (int i = 0; i < this.count; i++) {
        result.add(getRandom(sourceNames));
      }

      return result;
    }

    /**
     * Loads streets from the specified file.
     *
     * @param path the path to the file
     * @return a list of streetnames
     */
    private static List<String> loadStreets(final String path) {
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
        throw new NameLoadingException("Error loading streets", e);
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
