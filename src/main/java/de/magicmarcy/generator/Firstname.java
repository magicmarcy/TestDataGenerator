package de.magicmarcy.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.enums.Gender;
import de.magicmarcy.exceptions.NameLoadingException;
import de.magicmarcy.exceptions.ResourceNotFoundException;

/**
 * Creates random first names. Optional by {@link de.magicmarcy.enums.Gender}<br/>
 * Use {@code Firstname.builder()} to get a builder.
 *
 * Example:
 * <pre>{@code
 * List<String> names = Firstname.builder()
 *     .count(10)
 *     .build();
 * }</pre>
 * or
 * <pre>{@code
 *   final String name = Firstname.builder()
 *      .gender(Gender.FEMALE)
 *      .buildOne();
 * }</pre>
 *
 * @author magicmarcy
 */
public final class Firstname {

  private static final String FIRSTNAMES_MALE_FILE = "names/firstnames_male.txt";
  private static final String FIRSTNAMES_FEMALE_FILE = "names/firstnames_female.txt";

  private static final int DEFAULT_COUNT = 1;
  private static final Gender DEFAULT_GENDER = Gender.DIVERSE;

  private Firstname() {
    // Prevent instantiation
  }

  public static FirstnameBuilder builder() {
    return new FirstnameBuilder();
  }

  public static class FirstnameBuilder {
    private int count = DEFAULT_COUNT;
    private Gender gender = DEFAULT_GENDER;

    public FirstnameBuilder count(final int count) {
      this.count = count;
      return this;
    }

    public FirstnameBuilder gender(final Gender gender) {
      this.gender = gender;
      return this;
    }

    public String buildOne() {
      return buildList().get(0);
    }

    public List<String> buildList() {
      final List<String> sourceNames = new ArrayList<>();

      if (this.gender == null || this.gender == Gender.DIVERSE) {
        sourceNames.addAll(loadNames(FIRSTNAMES_MALE_FILE));
        sourceNames.addAll(loadNames(FIRSTNAMES_FEMALE_FILE));
      } else if (this.gender == Gender.MALE) {
        sourceNames.addAll(loadNames(FIRSTNAMES_MALE_FILE));
      } else {
        sourceNames.addAll(loadNames(FIRSTNAMES_FEMALE_FILE));
      }

      final List<String> result = new ArrayList<>();

      for (int i = 0; i < this.count; i++) {
        result.add(getRandom(sourceNames));
      }
      return result;
    }

    private static List<String> loadNames(final String path) {
      try (final InputStream is = Firstname.class.getClassLoader().getResourceAsStream(path)) {
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
