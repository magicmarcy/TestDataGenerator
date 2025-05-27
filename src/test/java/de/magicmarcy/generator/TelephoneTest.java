package de.magicmarcy.generator;

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

    final String telephone = Telephone.builder().countryCode(countryCode).buildOne();
    final String[] telephoneParts = telephone.split(Telephone.SPACE);

    Assertions.assertTrue(telephone.startsWith(telephonePrefix));
    Assertions.assertEquals(countryCode.getTelephoneCode(), telephoneParts[0]);
    Assertions.assertTrue(Integer.parseInt(telephoneParts[1]) >= Telephone.MINUIMUM_PREFIX_NUMBER);
    Assertions.assertTrue(Integer.parseInt(telephoneParts[1]) <= Telephone.MAXIMUM_PREFOX_NUMBER);

    Assertions.assertTrue(Integer.parseInt(telephoneParts[2]) >= Telephone.MINIMUM_NUMBER_VALUE);
    Assertions.assertTrue(Integer.parseInt(telephoneParts[2]) <= Telephone.MAXIMUM_NUMBER_VALUE);
  }

  @Test
  void get_a_random_english_telephone_number() {
    final CountryCode countryCode = CountryCode.USA;
    final String telephonePrefix = countryCode.getTelephoneCode();

    final String telephone = Telephone.builder().countryCode(countryCode).buildOne();
    final String[] telephoneParts = telephone.split(Telephone.SPACE);

    Assertions.assertTrue(telephone.startsWith(telephonePrefix));
    Assertions.assertEquals(countryCode.getTelephoneCode(), telephoneParts[0]);
    Assertions.assertTrue(Integer.parseInt(telephoneParts[1]) >= Telephone.MINUIMUM_PREFIX_NUMBER);
    Assertions.assertTrue(Integer.parseInt(telephoneParts[1]) <= Telephone.MAXIMUM_PREFOX_NUMBER);

    Assertions.assertTrue(Integer.parseInt(telephoneParts[2]) >= Telephone.MINIMUM_NUMBER_VALUE);
    Assertions.assertTrue(Integer.parseInt(telephoneParts[2]) <= Telephone.MAXIMUM_NUMBER_VALUE);
  }
}
