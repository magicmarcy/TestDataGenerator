package de.magicmarcy.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.enums.CountryCode;
import de.magicmarcy.enums.GenderType;
import de.magicmarcy.exceptions.NameLoadingException;
import de.magicmarcy.exceptions.ResourceNotFoundException;

/**
 * Creates random first names. Optional by {@link de.magicmarcy.enums.GenderType} and by {@link de.magicmarcy.enums.CountryCode}<br/>
 * If no CountryCode or no GenderType is specified, all names from all countries will be selected.<br/>
 * <br/>
 * Use {@code Firstname.builder()} to get a builder.<br/>
 * <br/>
 * Example:
 * <pre>{@code
 * List<String> names = Firstname.builder()
 *     .count(10)
 *     .build();
 * }</pre>
 * to get a list of 10 random first names for every gender and from any country, or
 * <pre>{@code
 *   final String name = Firstname.builder()
 *      .gender(Gender.FEMALE)
 *      .buildOne();
 * }</pre>
 * for a single female firstname or
 * <pre>{@code
 *   final String name = Firstname.builder()
 *      .gender(Gender.FEMALE)
 *      .country(CountryCode.GERMANY)
 *      .buildOne();
 * }</pre>
 * for a single female first name from Germany.
 *
 * @author magicmarcy
 */
public final class Firstname {

  /** Default number of results to generate */
  private static final int DEFAULT_COUNT = 1;

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
    private GenderType gender = null;
    private CountryCode countryCode = null;

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

    public FirstnameBuilder country(final CountryCode countryCode) {
      this.countryCode = countryCode;
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
      final List<GenderType> gendersToLoad = getGenderTypesList();
      final List<CountryCode> countriesToLoad = getCountryCodesList();

      fillSourceNamesList(gendersToLoad, countriesToLoad, sourceNames);

      return createResultList(sourceNames);
    }

    private List<String> createResultList(List<String> sourceNames) {
      final List<String> result = new ArrayList<>();

      for (int i = 0; i < this.count; i++) {
        result.add(getRandom(sourceNames));
      }
      return result;
    }

    /**
     * Fills the source names list with names from the given GenderTyoe and CountryCode
     * @param gendersToLoad List of specified GenderType (all if not specified
     * @param countriesToLoad List of specified CountryCode (all if not specified)
     * @param sourceNames ResultList with names
     */
    private void fillSourceNamesList(List<GenderType> gendersToLoad, List<CountryCode> countriesToLoad, List<String> sourceNames) {
      for (GenderType selectedGenderType : gendersToLoad) {
        for (CountryCode selectedCountryCode : countriesToLoad) {
          String path = "files/" + selectedCountryCode.getFoldername() + "/firstnames_" + selectedGenderType.getFileNamePart() + ".txt";
          sourceNames.addAll(loadNames(path));
        }
      }
    }

    /**
     * Returns a list of country codes to load names from.
     * @return a list of {@link de.magicmarcy.enums.CountryCode}
     */
    private List<CountryCode> getCountryCodesList() {
      final List<CountryCode> countriesToLoad;
      if (this.countryCode == null) {
        countriesToLoad = Arrays.asList(CountryCode.values());
      } else {
        countriesToLoad = Collections.singletonList(this.countryCode);
      }
      return countriesToLoad;
    }

    /**
     * Returns a list of gender types to load names from.
     * @return a list of {@link de.magicmarcy.enums.GenderType}
     */
    private List<GenderType> getGenderTypesList() {
      final List<GenderType> gendersToLoad;
      if (this.gender == null) {
        gendersToLoad = Arrays.asList(GenderType.values());
      } else {
        gendersToLoad = Collections.singletonList(this.gender);
      }
      return gendersToLoad;
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
