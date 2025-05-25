package de.magicmarcy.generator;

import de.magicmarcy.enums.CountryCode;
import de.magicmarcy.enums.GenderType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy
 */
class FirstnameTest {

  @Test
  void get_one_random_firstname() {
    final String firstname = Firstname.builder().buildOne();

    Assertions.assertNotNull(firstname);
    Assertions.assertFalse(firstname.isEmpty());
  }

  @Test
  void get_one_random_female_firstname() {
    final String firstname = Firstname.builder().gender(GenderType.FEMALE).buildOne();

    Assertions.assertNotNull(firstname);
    Assertions.assertFalse(firstname.isEmpty());
  }

  @Test
  void get_one_random_german_female_firstname() {
    final String firstname = Firstname.builder().gender(GenderType.FEMALE).country(CountryCode.GERMANY).buildOne();

    Assertions.assertNotNull(firstname);
    Assertions.assertFalse(firstname.isEmpty());
  }

  @Test
  void get_one_random_german_male_firstname() {
    final String firstname = Firstname.builder().gender(GenderType.MALE).country(CountryCode.GERMANY).buildOne();

    Assertions.assertNotNull(firstname);
    Assertions.assertFalse(firstname.isEmpty());
  }

  @Test
  void get_one_random_english_female_firstname() {
    final String firstname = Firstname.builder().gender(GenderType.FEMALE).country(CountryCode.USA).buildOne();

    Assertions.assertNotNull(firstname);
    Assertions.assertFalse(firstname.isEmpty());
  }

  @Test
  void get_one_random_english_male_firstname() {
    final String firstname = Firstname.builder().gender(GenderType.MALE).country(CountryCode.USA).buildOne();

    Assertions.assertNotNull(firstname);
    Assertions.assertFalse(firstname.isEmpty());
  }
}
