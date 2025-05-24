package de.magicmarcy.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy | 24.05.2025
 */
public class StreetTest {

  @Test
  void get_one_random_streetname() {
    final String street = Street.builder().buildOne();

    System.out.println(street);

    Assertions.assertNotNull(street);
    Assertions.assertFalse(street.isEmpty());
  }
}
