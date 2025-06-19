package de.magicmarcy.generator;

import java.util.List;

/**
 * @author magicmarcy
 */
public sealed interface Generator<T>
    permits
      Birthdate.BirthdateBuilder,
      Country.CountryBuilder,
      Firstname.FirstnameBuilder,
      Lastname.LastnameBuilder,
      Number.NumberBuilder,
      Street.StreetBuilder,
      Telephone.TelephoneBuilder {

  T buildOne();

  List<T> build(int count);
}
