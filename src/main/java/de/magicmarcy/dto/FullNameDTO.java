package de.magicmarcy.dto;

/**
 * @author magicmarcy
 */
public class FullNameDTO {

  private String surname;
  private String lastname;

  public FullNameDTO() {
    super();
  }

  public FullNameDTO(String surname, String lastname) {
    this.surname = surname;
    this.lastname = lastname;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(String lastname) {
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
