package de.magicmarcy.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.exceptions.NameLoadingException;
import de.magicmarcy.exceptions.ResourceNotFoundException;

/**
 * Creates random last names. <br/>
 * Use {@code Lastname.builder()} to get a builder.
 *
 * Example:
 * <pre>{@code
 * List<String> names = Lastname.builder()
 *     .count(10)
 *     .build();
 * }</pre>
 * or
 * <pre>{@code
 *   final String name = Lastname.builder().buildOne();
 * }</pre>
 *
 * @author magicmarcy
 */
public final class Lastname {

  /** Default number of results to generate */
  private static final int DEFAULT_COUNT = 1;

  /** Path to the lastnames file */
  private static final String LASTNAMES_FILE = "names/lastnames.txt";

  private Lastname() {
    // Prevent instantiation
  }

  public static LastnameBuilder builder() {
    return new LastnameBuilder();
  }

  public static class LastnameBuilder {
    private int count = DEFAULT_COUNT;

    public LastnameBuilder count(final int count) {
      this.count = count;
      return this;
    }

    public String buildOne() {
      return buildList().get(0);
    }

    public List<String> buildList() {
      final List<String> sourceNames = new ArrayList<>(loadNames(LASTNAMES_FILE));
      final List<String> result = new ArrayList<>();

      for (int i = 0; i < this.count; i++) {
        result.add(getRandom(sourceNames));
      }

      return result;
    }

    private static List<String> loadNames(final String path) {
      try (final InputStream is = Lastname.class.getClassLoader().getResourceAsStream(path)) {
        if (is == null) {
          throw new ResourceNotFoundException("File not found: " + path);
        }

        return new BufferedReader(new InputStreamReader(is))
            .lines()
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .toList();

      } catch (final IOException e) {
        throw new NameLoadingException("Error loading names", e);
      }
    }

    private static String getRandom(final List<String> list) {
      return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
  }
}
