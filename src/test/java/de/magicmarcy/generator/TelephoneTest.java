package de.magicmarcy.generator;

import de.magicmarcy.dto.TelephoneDTO;
import de.magicmarcy.enums.CountryCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy
 */
class TelephoneTest {

  @Test
  void get_a_random_german_telephone_number() {
    final CountryCode countryCode = CountryCode.GERMANY;
    final String telephonePrefix = countryCode.getTelephoneCode();

    final TelephoneDTO telephone = Telephone.builder().countryCode(countryCode).buildOne();

    Assertions.assertEquals(telephone.getCountryPrefix(), telephonePrefix);
    Assertions.assertTrue(Integer.parseInt(telephone.getCityPrefix()) >= Telephone.MINUIMUM_PREFIX_NUMBER);
    Assertions.assertTrue(Integer.parseInt(telephone.getCityPrefix()) <= Telephone.MAXIMUM_PREFOX_NUMBER);

    Assertions.assertTrue(Integer.parseInt(telephone.getNumber()) >= Telephone.MINIMUM_NUMBER_VALUE);
    Assertions.assertTrue(Integer.parseInt(telephone.getNumber()) <= Telephone.MAXIMUM_NUMBER_VALUE);
  }

  @Test
  void get_a_random_english_telephone_number() {
    final CountryCode countryCode = CountryCode.USA;
    final String telephonePrefix = countryCode.getTelephoneCode();

    final TelephoneDTO telephone = Telephone.builder().countryCode(countryCode).buildOne();

    Assertions.assertEquals(telephone.getCountryPrefix(), telephonePrefix);
    Assertions.assertTrue(Integer.parseInt(telephone.getCityPrefix()) >= Telephone.MINUIMUM_PREFIX_NUMBER);
    Assertions.assertTrue(Integer.parseInt(telephone.getCityPrefix()) <= Telephone.MAXIMUM_PREFOX_NUMBER);

    Assertions.assertTrue(Integer.parseInt(telephone.getNumber()) >= Telephone.MINIMUM_NUMBER_VALUE);
    Assertions.assertTrue(Integer.parseInt(telephone.getNumber()) <= Telephone.MAXIMUM_NUMBER_VALUE);
  }

  @Test
  void get_a_random_telephone_number() {
    final TelephoneDTO telephone = Telephone.builder().buildOne();

    System.out.println(telephone.prettyPrint());

    Assertions.assertNotNull(telephone);
    Assertions.assertNotNull(telephone.getCountryPrefix());
    Assertions.assertNotNull(telephone.getCityPrefix());
    Assertions.assertNotNull(telephone.getNumber());

    Assertions.assertFalse(telephone.getCountryPrefix().isEmpty());
    Assertions.assertFalse(telephone.getCityPrefix().isEmpty());
    Assertions.assertFalse(telephone.getNumber().isEmpty());
  }
}
