package de.magicmarcy.generator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.exceptions.SameAgeException;

/**
 * Creates random birthdates of the given borders.
 * Use {@code Birthdate.builder()} to get a builder.
 * <br/>
 * Example:
 * <pre>{@code
 * List<LocalDate> dates = Birthdate.builder()
 *     .minAge(20)
 *     .maxAge(60)
 *     .count(10)
 *     .build();
 * }</pre>
 *
 * @author magicmarcy
 */
public final class Birthdate {

  private static final int DEFAULT_MIN_AGE = 18;
  private static final int DEFAULT_MAX_AGE = 90;

  /**
   * Default constructor to prevent instantiation.
   */
  private Birthdate() {
    // Prevent instantiation
  }

  /**
   * Creates a new builder for generating birth dates.
   *
   * @return a new instance of {@link de.magicmarcy.generator.Birthdate.BirthdateBuilder}
   */
  public static BirthdateBuilder builder() {
    return new BirthdateBuilder();
  }

  /**
   * Builder class for generating birth dates.
   */
  public static final class BirthdateBuilder implements Generator<LocalDate> {
    private int minAge = DEFAULT_MIN_AGE;
    private int maxAge = DEFAULT_MAX_AGE;

    /**
     * Sets the minimum age for the generated birthdate.
     * Minimum age does not match the maximum age.
     *
     * @param minAge the minimum age
     * @return this builder
     */
    public BirthdateBuilder minAge(int minAge) {
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
    public BirthdateBuilder maxAge(int maxAge) {
      this.maxAge = maxAge;
      return this;
    }

    /**
     * Generates a single random birth date.
     *
     * @return a random birth date
     * @throws SameAgeException if min and max age are the same
     */
    @Override
    public LocalDate buildOne() {
      if (this.minAge == this.maxAge) {
        throw new SameAgeException("Min and max age must not be the same");
      }

      return build(1).get(0);
    }

    /**
     * Generates a list of random birth dates.
     *
     * @return a list of random birth dates
     */
    @Override
    public List<LocalDate> build(int count) {
      List<LocalDate> birthDates = new ArrayList<>(count);

      LocalDate minDate = LocalDate.now().minusYears(this.minAge);
      LocalDate maxDate = LocalDate.now().minusYears(this.maxAge);

      for (int i = 0; i < count; i++) {
        birthDates.add(getRandomBirthdate(minDate, maxDate));
      }

      return birthDates;
    }

    /**
     * Generates a random birth date between the specified minimum and maximum dates.
     *
     * @param minDate the minimum date
     * @param maxDate the maximum date
     * @return a random birth date
     */
    private static LocalDate getRandomBirthdate(LocalDate minDate, LocalDate maxDate) {
      LocalDate startDate = minDate.isBefore(maxDate) ? minDate : maxDate;
      LocalDate endDate = minDate.isBefore(maxDate) ? maxDate : minDate;

      long startEpochDay = startDate.toEpochDay();
      long endEpochDay = endDate.toEpochDay();
      long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);

      return LocalDate.ofEpochDay(randomDay);
    }
  }
}
