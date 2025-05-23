package de.magicmarcy.dto;

/**
 * @author magicmarcy | 23.05.2025
 */
public class FullName {

  private String surname;
  private String lastname;

  public FullName() {
    super();
  }

  public FullName(final String surname, final String lastname) {
    this.surname = surname;
    this.lastname = lastname;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(final String lastname) {
    this.lastname = lastname;
  }

  @Override
  public String toString() {
    return "FullName{" +
        "surname='" + this.surname + '\'' +
        ", lastname='" + this.lastname + '\'' +
        '}';
  }
}
