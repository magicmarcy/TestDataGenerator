package de.magicmarcy;

import java.time.LocalDate;

import de.magicmarcy.enums.Gender;
import de.magicmarcy.generator.BirthDate;
import de.magicmarcy.generator.Firstname;
import de.magicmarcy.generator.Lastname;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy | 23.05.2025
 */
class PersonGeneratorTest {

  @Test
  void get_one_random_firstname() {
    final String firstname = Firstname.builder().buildOne();

    Assertions.assertNotNull(firstname);
    Assertions.assertFalse(firstname.isEmpty());
  }

  @Test
  void get_one_random_female_firstname() {
    final String firstname = Firstname.builder().gender(Gender.FEMALE).buildOne();

    Assertions.assertNotNull(firstname);
    Assertions.assertFalse(firstname.isEmpty());
  }

  @Test
  void get_one_random_lastname() {
    final String lastname = Lastname.builder().buildOne();

    Assertions.assertNotNull(lastname);
    Assertions.assertFalse(lastname.isEmpty());
  }

  @Test
  void get_one_random_birthdate() {
    final LocalDate birthdate = BirthDate.builder().buildOne();

    Assertions.assertNotNull(birthdate);
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now()));
  }

  @Test
  void get_one_random_birthdate_between_20_and_21() {
    final LocalDate birthdate = BirthDate.builder().minAge(20).maxAge(21).buildOne();

    Assertions.assertNotNull(birthdate);
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now()));
    Assertions.assertTrue(birthdate.isAfter(LocalDate.now().minusYears(21)));
    Assertions.assertTrue(birthdate.isBefore(LocalDate.now().minusYears(20)));
  }
}
