package de.magicmarcy.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.enums.CountryCode;

/**
 * @author magicmarcy | 24.05.2025
 */
public final class Country {

  /** Default number of results to generate */
  private static final int DEFAULT_COUNT = 1;

  /**
   * Default constructor to prevent instantiation.
   */
  private Country() {
    // Prevent instantiation
  }

  public static CountryBuilder builder() {
    return new CountryBuilder();
  }

  public static class CountryBuilder {
    private int count = DEFAULT_COUNT;

    /**
     * Sets the number of countries to generate.
     *
     * @param count the number of countries
     * @return this builder
     */
    public CountryBuilder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * Builds a random country or a list of random countries.
     *
     * @return a random country or a list of random countries
     */
    public List<CountryCode> build() {
      final List<CountryCode> countries = new ArrayList<>();

      for (int i = 0; i < this.count; i++) {
        countries.add(getRandomCountry());
      }

      return countries;
    }

    /**
     * Generates a single random country.
     *
     * @return a random country
     */
    public CountryCode buildOne() {
      return getRandomCountry();
    }

    public static CountryCode getRandomCountry() {
      CountryCode[] countries = CountryCode.values();
      int randomIndex = ThreadLocalRandom.current().nextInt(countries.length);
      return countries[randomIndex];
    }
  }
}
