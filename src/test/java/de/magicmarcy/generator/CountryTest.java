package de.magicmarcy.generator;

import java.util.List;
import java.util.Set;

import de.magicmarcy.enums.CountryCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy
 */
class CountryTest {

  @Test
  void get_one_random_country() {
    final CountryCode country = Country.builder().buildOne();

    Assertions.assertNotNull(country);
    Assertions.assertFalse(country.getTelephoneCode().isEmpty());
  }

  @Test
  void get_10_random_countries() {
    final List<CountryCode> country = Country.builder().count(10).build();

    Assertions.assertNotNull(country);
    Assertions.assertFalse(country.isEmpty());
    Assertions.assertEquals(10, country.size());

    Set<CountryCode> callCuntryCodes = Set.of(CountryCode.values());

    for (final CountryCode cc : country) {
      Assertions.assertTrue(callCuntryCodes.contains(cc));
    }
  }
}
