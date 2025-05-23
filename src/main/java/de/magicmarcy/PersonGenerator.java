package de.magicmarcy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import de.magicmarcy.dto.Person;

public class PersonGenerator {
  private final List<Person> persons;

  public PersonGenerator(int count) {
    this.persons = IntStream.range(0, count)
        .mapToObj(i -> new Person())
        .collect(Collectors.toList());
  }

  public PersonGenerator withBirthDates() {
    for (Person p : persons) {
//      p.setBirthDate(randomDate());
    }
    return this;
  }

  public PersonGenerator withAddresses() {
    for (Person p : persons) {
//      p.setAddress(randomAddress());
    }
    return this;
  }

  public List<Person> build() {
    return persons;
  }
}
