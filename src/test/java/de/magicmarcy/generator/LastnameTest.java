package de.magicmarcy.generator;

import de.magicmarcy.enums.CountryCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy
 */
class LastnameTest {

  @Test
  void get_one_random_lastname() {
    final String lastname = Lastname.builder().buildOne();

    Assertions.assertNotNull(lastname);
    Assertions.assertFalse(lastname.isEmpty());
  }

  @Test
  void get_one_random_german_lastname() {
    final String lastname = Lastname.builder().country(CountryCode.GERMANY).buildOne();

    Assertions.assertNotNull(lastname);
    Assertions.assertFalse(lastname.isEmpty());
  }

  @Test
  void get_one_random_english_lastname() {
    final String lastname = Lastname.builder().country(CountryCode.USA).buildOne();

    Assertions.assertNotNull(lastname);
    Assertions.assertFalse(lastname.isEmpty());
  }
}
