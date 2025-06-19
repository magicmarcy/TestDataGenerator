package de.magicmarcy.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.enums.CountryCode;

/**
 * @author magicmarcy | 24.05.2025
 */
public final class Country {

  /**
   * Default constructor to prevent instantiation.
   */
  private Country() {
    // Prevent instantiation
  }

  public static CountryBuilder builder() {
    return new CountryBuilder();
  }

  public static final class CountryBuilder implements Generator<CountryCode> {

    /**
     * Generates a single random country.
     *
     * @return a random country
     */
    @Override
    public CountryCode buildOne() {
      return build(1).get(0);
    }

    /**
     * Generates a random country list. Does not make many sense cause there are only two countries available at the moment.
     *
     * @return a random country
     */
    @Override
    public List<CountryCode> build(int count) {
      List<CountryCode> countries = new ArrayList<>(count);

      for (int i = 0; i < count; i++) {
        countries.add(getRandomCountry());
      }

      return countries;
    }

    private static CountryCode getRandomCountry() {
      CountryCode[] countries = CountryCode.values();
      int randomIndex = ThreadLocalRandom.current().nextInt(countries.length);

      return countries[randomIndex];
    }
  }
}
