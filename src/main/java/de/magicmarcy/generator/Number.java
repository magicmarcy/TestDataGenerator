package de.magicmarcy.generator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Creates a random number.<br/>
 * Use {@code Number.builder()} to get a builder.
 * <br/>
 * Example:
 * <pre>{@code
 * final int number = Number.builder()
 *     .buildOne();
 * }</pre>
 * or
 * <pre>{@code
 *   final int number = Number.builder()
 *      .range(10, 20)
 *      .buildOne();
 * }</pre>
 *
 * @author magicmarcy
 */
public final class Number {

  public static final int DEFAULT_FROM = 0;
  public static final int DEFAULT_TO = 100;

  private Number() {
    // private constructor to prevent instantiation
  }

  public static NumberBuilder builder() {
    return new NumberBuilder();
  }

  public static class NumberBuilder {
    private int from = DEFAULT_FROM;
    private int to = DEFAULT_TO;

    public NumberBuilder range(final int from, final int to) {
      this.from = from;
      this.to = to;
      return this;
    }

    public int buildOne() {
      return ThreadLocalRandom.current().nextInt(from, to + 1);
    }
  }
}
