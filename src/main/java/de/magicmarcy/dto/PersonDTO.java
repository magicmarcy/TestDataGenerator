package de.magicmarcy.dto;

import java.time.LocalDate;

/**
 * @author magicmarcy
 */
public class PersonDTO {

  private String name;
  private String surname;
  private LocalDate birthDate;
  private AddressDTO address;
  private String email;
  private String phoneNumber;

  public PersonDTO() {
    super();
  }

  public PersonDTO(String name, String surname, LocalDate birthDate, AddressDTO address, String email, String phoneNumber) {
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

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public AddressDTO getAddress() {
    return address;
  }

  public void setAddress(AddressDTO address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
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
