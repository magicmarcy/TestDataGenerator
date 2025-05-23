package de.magicmarcy.generator;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy | 23.05.2025
 */
class BirthdateTest {

  @Test
  void get_one_random_birthdate() {
    final LocalDate birthdate = Birthdate.builder().buildOne();

    Assertions.assertNotNull(birthdate);
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now()));
  }

  @Test
  void get_one_random_birthdate_between_20_and_21() {
    final LocalDate birthdate = Birthdate.builder().minAge(20).maxAge(21).buildOne();

    Assertions.assertNotNull(birthdate);
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now()));
    Assertions.assertTrue(birthdate.isAfter(LocalDate.now().minusYears(21)));
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now().minusYears(20)));
  }
}
