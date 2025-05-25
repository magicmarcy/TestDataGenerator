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
}
