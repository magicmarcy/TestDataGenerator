package de.magicmarcy.generator;

import de.magicmarcy.enums.CountryCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy
 */
class StreetTest {

  @Test
  void get_one_random_streetname() {
    final String street = Street.builder().buildOne();

    Assertions.assertNotNull(street);
    Assertions.assertFalse(street.isEmpty());
  }

  @Test
  void get_one_random_germann_streetname() {
    final String street = Street.builder().country(CountryCode.GERMANY).buildOne();

    Assertions.assertNotNull(street);
    Assertions.assertFalse(street.isEmpty());
  }

  @Test
  void get_one_random_usa_streetname() {
    final String street = Street.builder().country(CountryCode.USA).buildOne();

    Assertions.assertNotNull(street);
    Assertions.assertFalse(street.isEmpty());
  }

  @Test
  void get_one_random_german_streetname_with_number() {
    final CountryCode countryCode = CountryCode.GERMANY;

    final String street = Street.builder().country(countryCode).withNumber().buildOne();

    Assertions.assertNotNull(street);
    Assertions.assertFalse(street.isEmpty());

    String[] streetParts = street.split(" ");

    try {
      // in a german street the number is always the last part of the street name
      int houseNumber = Integer.parseInt(streetParts[streetParts.length - 1]);

      Assertions.assertTrue(houseNumber >= Street.MINIMUM_STREET_NUMBER_DE && houseNumber <= Street.MAXIMUM_STREET_NUMBER_DE);
    } catch (NumberFormatException e) {
      Assertions.fail("Streetno is not a number: " + street.split(" ")[streetParts.length - 1]);
    }
  }

  @Test
  void get_one_random_english_streetname_with_number() {
    final CountryCode countryCode = CountryCode.USA;

    final String street = Street.builder().country(countryCode).withNumber().buildOne();

    Assertions.assertNotNull(street);
    Assertions.assertFalse(street.isEmpty());

    String[] streetParts = street.split(" ");

    try {
      // in an english street the number is always the first part of the street name
      int houseNumber = Integer.parseInt(streetParts[0]);
      Assertions.assertTrue(houseNumber >= Street.MINIMUM_STREET_NUMBER_EN && houseNumber <= Street.MAXIMUM_STREET_NUMBER_EN);
    } catch (NumberFormatException e) {
      Assertions.fail("Streetno is not a number: " + streetParts[0]);
    }
  }
}
