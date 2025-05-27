package de.magicmarcy.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy
 */
class NumberTest {

  @Test
  void get_one_random_number() {
    int number = Number.builder().buildOne();

    for (int i = 0; i < 100; i++) {
      Assertions.assertTrue(number >= Number.DEFAULT_FROM && number <= Number.DEFAULT_TO);
    }
  }

  @Test
  void get_one_random_number_between_10_and_20() {
    final int number = Number.builder().range(10, 20).buildOne();

    for (int i = 0; i < 100; i++) {
      Assertions.assertTrue(number >= 10 && number <= 20);
    }
  }
}
