package de.magicmarcy.generator;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author magicmarcy | 24.05.2025
 */
public class NumberTest {

  @Test
  void get_one_random_number() {
    final int number = Number.builder().buildOne();

    for (int i = 0; i < 100; i++) {
      Assertions.assertTrue(number >= 0 && number <= 100);
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
