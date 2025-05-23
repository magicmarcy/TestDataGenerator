package de.magicmarcy.dto;

import java.time.LocalDate;

/**
 * @author magicmarcy | 23.05.2025
 */
public class Person {

  private String name;
  private String surname;
  private LocalDate birthDate;
  private Address address;
  private String email;
  private String phoneNumber;

  public Person() {
    super();
  }

  public Person(final String name, final String surname, final LocalDate birthDate, final Address address, final String email, final String phoneNumber) {
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  // Getter and Setter methods for each field

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(final LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(final Address address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", birthDate=" + birthDate +
        ", address=" + address +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        '}';
  }
}
