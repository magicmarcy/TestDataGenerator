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

public class Street {

  /** Default number of results to generate */
  private static final int DEFAULT_COUNT = 1;

  public static final int MINIMUM_STREET_NUMBER_DE = 1;
  public static final int MAXIMUM_STREET_NUMBER_DE = 299;
  public static final int MINIMUM_STREET_NUMBER_EN = 1000;
  public static final int MAXIMUM_STREET_NUMBER_EN = 9999;

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
    private boolean withNumber = false;

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

    public StreetBuilder withNumber() {
      this.withNumber = true;
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
      final List<String> sourceNames = new ArrayList<>();

      if (this.countryCode == null) {
        for (final CountryCode code : CountryCode.values()) {
          sourceNames.addAll(loadStreets("files/" + code.getFoldername() + "/streetnames.txt"));
        }
      } else {
        sourceNames.addAll(loadStreets("files/" + this.countryCode.getFoldername() + "/streetnames.txt"));
      }

      final List<String> resultList = new ArrayList<>();

      for (int i = 0; i < this.count; i++) {
        String streetResult = getRandom(sourceNames);

        if (this.withNumber) {
          if (this.countryCode == CountryCode.GERMANY) {
            streetResult += " " + ThreadLocalRandom.current().nextInt(MINIMUM_STREET_NUMBER_DE, MAXIMUM_STREET_NUMBER_DE);
          } else if (this.countryCode == CountryCode.USA) {
            streetResult = ThreadLocalRandom.current().nextInt(MINIMUM_STREET_NUMBER_EN, MAXIMUM_STREET_NUMBER_EN) + " " + streetResult;
          }
        }

        resultList.add(streetResult);
      }

      return resultList;
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
        throw new FileContentLoadingException("Error loading streets", e);
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
