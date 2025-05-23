package de.magicmarcy.generator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.exceptions.SameAgeException;

/**
 * Creates random birthdates of the given borders.
 * Use {@code BirthDate.builder()} to get a builder.
 *
 * Example:
 * <pre>{@code
 * List<LocalDate> dates = BirthDate.builder()
 *     .minAge(20)
 *     .maxAge(60)
 *     .count(10)
 *     .build();
 * }</pre>
 *
 * @author magicmarcy
 */
public final class BirthDate {

  private static final int DEFAULT_MIN_AGE = 18;
  private static final int DEFAULT_MAX_AGE = 90;
  private static final int DEFAULT_COUNT = 1;

  private BirthDate() {
    // Prevent instantiation
  }

  public static BirthDateBuilder builder() {
    return new BirthDateBuilder();
  }

  public static class BirthDateBuilder {
    private int minAge = DEFAULT_MIN_AGE;
    private int maxAge = DEFAULT_MAX_AGE;
    private int count = DEFAULT_COUNT;

    /**
     * Sets the minimum age for the generated birthdate.
     * Minimum age does not match the maximum age.
     *
     * @param minAge the minimum age
     * @return this builder
     */
    public BirthDateBuilder minAge(int minAge) {
      this.minAge = minAge;
      return this;
    }

    /**
     * Sets the maximum age for the generated birthdate.
     * Maximum age does not match the minimum age.
     *
     * @param maxAge the maximum age
     * @return this builder
     */
    public BirthDateBuilder maxAge(final int maxAge) {
      this.maxAge = maxAge;
      return this;
    }

    public BirthDateBuilder count(final int count) {
      this.count = count;
      return this;
    }

    public LocalDate buildOne() {
      if (this.minAge == this.maxAge) {
        throw new SameAgeException("Min and max age must not be the same");
      }

      return buildList().get(0);
    }

    public List<LocalDate> buildList() {
      final List<LocalDate> birthDates = new ArrayList<>();
      LocalDate minDate = LocalDate.now().minusYears(minAge);
      LocalDate maxDate = LocalDate.now().minusYears(maxAge);

      for (int i = 0; i < count; i++) {
        birthDates.add(getRandomBirthDate(minDate, maxDate));
      }

      return birthDates;
    }

    private static LocalDate getRandomBirthDate(LocalDate minDate, LocalDate maxDate) {
      LocalDate startDate = minDate.isBefore(maxDate) ? minDate : maxDate;
      LocalDate endDate = minDate.isBefore(maxDate) ? maxDate : minDate;

      long startEpochDay = startDate.toEpochDay();
      long endEpochDay = endDate.toEpochDay();
      long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);

      return LocalDate.ofEpochDay(randomDay);
    }
  }
}
