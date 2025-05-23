package de.magicmarcy.generator;

import de.magicmarcy.enums.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy | 23.05.2025
 */
public class FirstnameTest {

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
}
