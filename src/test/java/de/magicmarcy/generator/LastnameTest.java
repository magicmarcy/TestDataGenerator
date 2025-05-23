package de.magicmarcy.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy | 23.05.2025
 */
class LastnameTest {

  @Test
  void get_one_random_lastname() {
    final String lastname = Lastname.builder().buildOne();

    Assertions.assertNotNull(lastname);
    Assertions.assertFalse(lastname.isEmpty());
  }
}
