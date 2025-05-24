package de.magicmarcy.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.enums.GenderType;
import de.magicmarcy.exceptions.NameLoadingException;
import de.magicmarcy.exceptions.ResourceNotFoundException;

/**
 * Creates random first names. Optional by {@link de.magicmarcy.enums.GenderType}<br/>
 * Use {@code Firstname.builder()} to get a builder.
 *
 * Example:
 * <pre>{@code
 * List<String> names = Firstname.builder()
 *     .count(10)
 *     .build();
 * }</pre>
 * or
 * <pre>{@code
 *   final String name = Firstname.builder()
 *      .gender(Gender.FEMALE)
 *      .buildOne();
 * }</pre>
 *
 * @author magicmarcy
 */
public final class Firstname {

  /** Path to the file with the male first names */
  private static final String FIRSTNAMES_MALE_FILE = "names/firstnames_male.txt";

  /** Path to the file with the female first names */
  private static final String FIRSTNAMES_FEMALE_FILE = "names/firstnames_female.txt";

  /** Default number of results to generate */
  private static final int DEFAULT_COUNT = 1;

  /** Default gender for the generated names */
  private static final GenderType DEFAULT_GENDER = GenderType.DIVERSE;

  /**
   * Default constructor to prevent instantiation.
   */
  private Firstname() {
    // Prevent instantiation
  }

  /**
   * Creates a new builder for generating first names.
   *
   * @return a new instance of {@link FirstnameBuilder}
   */
  public static FirstnameBuilder builder() {
    return new FirstnameBuilder();
  }

  /**
   * Builder class for generating first names.
   * <p>
   * Use {@code Firstname.builder()} to get a builder.
   * </p>
   */
  public static class FirstnameBuilder {
    private int count = DEFAULT_COUNT;
    private GenderType gender = DEFAULT_GENDER;

    /**
     * Sets the number of first names to generate.
     *
     * @param count the number of first names
     * @return this builder
     */
    public FirstnameBuilder count(final int count) {
      this.count = count;
      return this;
    }

    /**
     * Sets the gender for the generated first names.
     * @param gender the {@link de.magicmarcy.enums.GenderType}
     * @return this builder
     */
    public FirstnameBuilder gender(final GenderType gender) {
      this.gender = gender;
      return this;
    }

    /**
     * Generates a single random first name.
     *
     * @return a random first name
     */
    public String buildOne() {
      return buildList().get(0);
    }

    /**
     * Generates a list of random first names.
     *
     * @return a list of random first names
     */
    public List<String> buildList() {
      final List<String> sourceNames = new ArrayList<>();

      if (this.gender == null || this.gender == GenderType.DIVERSE) {
        sourceNames.addAll(loadNames(FIRSTNAMES_MALE_FILE));
        sourceNames.addAll(loadNames(FIRSTNAMES_FEMALE_FILE));
      } else if (this.gender == GenderType.MALE) {
        sourceNames.addAll(loadNames(FIRSTNAMES_MALE_FILE));
      } else {
        sourceNames.addAll(loadNames(FIRSTNAMES_FEMALE_FILE));
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
      try (final InputStream is = Firstname.class.getClassLoader().getResourceAsStream(path)) {
        if (is == null) {
          throw new ResourceNotFoundException("File not found: " + path);
        }

        return new BufferedReader(new InputStreamReader(is))
            .lines()
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .toList();

      } catch (final IOException e) {
        throw new NameLoadingException("Error loading names", e);
      }
    }

    /**
     * Returns a random name from the provided list.
     *
     * @param list the list of names
     * @return a random name
     */
    private static String getRandom(final List<String> list) {
      return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
  }
}
