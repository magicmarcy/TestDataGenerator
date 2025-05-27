package de.magicmarcy.generator;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Creates a random number.<br/>
 * Use {@code Number.builder()} to get a builder.
 * <br/>
 * Example:
 * <pre>{@code
 * int number = Number.builder()
 *     .buildOne();
 * }</pre>
 * or
 * <pre>{@code
 *   int number = Number.builder()
 *      .range(10, 20)
 *      .buildOne();
 * }</pre>
 *
 * @author magicmarcy
 */
public final class Number {

  /** Default minimum range for generated numbers */
  public static final int DEFAULT_FROM = 0;

  /** Default maximum range for generated numbers */
  public static final int DEFAULT_TO = 100;

  /**
   * Default constructor to prevent instantiation.
   */
  private Number() {
    // private constructor to prevent instantiation
  }

  /**
   * Creates a new builder for generating random numbers.
   *
   * @return a new instance of {@link NumberBuilder}
   */
  public static NumberBuilder builder() {
    return new NumberBuilder();
  }

  /**
   * Builder class for generating random numbers.
   */
  public static final class NumberBuilder implements Generator<Integer> {
    private int from = DEFAULT_FROM;
    private int to = DEFAULT_TO;

    /**
     * Sets the range for generated numbers.
     *
     * @param from the minimum value (inclusive)
     * @param to   the maximum value (inclusive)
     * @return this builder
     */
    public NumberBuilder range(int from, int to) {
      this.from = from;
      this.to = to;
      return this;
    }

    /**
     * Generates a random number within the specified range.
     *
     * @return a random number
     */
    @Override
    public Integer buildOne() {
      return build(1).get(0);
    }

    @Override
    public List<Integer> build(int count) {
      return ThreadLocalRandom.current().ints(count, from, to + 1)
          .boxed()
          .toList();
    }
  }
}
