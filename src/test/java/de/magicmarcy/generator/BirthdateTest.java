package de.magicmarcy.generator;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy
 */
class BirthdateTest {

  @Test
  void get_one_random_birthdate() {
    LocalDate birthdate = Birthdate.builder().buildOne();

    Assertions.assertNotNull(birthdate);
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now()));
  }

  @Test
  void get_one_random_birthdate_between_20_and_21() {
    LocalDate birthdate = Birthdate.builder().minAge(20).maxAge(21).buildOne();

    Assertions.assertNotNull(birthdate);
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now()));
    Assertions.assertTrue(birthdate.isAfter(LocalDate.now().minusYears(21)));
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now().minusYears(20)));
  }

  @Test
  void get_one_random_birthdate_between_21_and_20() {
    LocalDate birthdate = Birthdate.builder().minAge(21).maxAge(20).buildOne();

    Assertions.assertNotNull(birthdate);
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now()));
    Assertions.assertTrue(birthdate.isAfter(LocalDate.now().minusYears(21)));
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now().minusYears(20)));
  }

  @Test
  void get_10_random_birthdates() {
    List<LocalDate> birthdates = Birthdate.builder().build(10);

    Assertions.assertNotNull(birthdates);
    Assertions.assertEquals(10, birthdates.size());

    for (LocalDate birthdate : birthdates) {
      Assertions.assertNotNull(birthdate);
      Assertions.assertTrue(birthdate.isBefore(LocalDate.now()));
    }
  }
}
