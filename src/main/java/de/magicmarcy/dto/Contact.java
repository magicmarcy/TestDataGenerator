package de.magicmarcy.dto;

import java.util.List;

/**
 * @author magicmarcy | 23.05.2025
 */
public class Contact {

  private String name;
  private String surname;
  private String phone;
  private String email;
  private List<Social> socialAccounts;

  public Contact() {
    super();
  }

  public Contact(final String name, final String surname, final String phone, final String email, final List<Social> socialAccounts) {
    this.name = name;
    this.surname = surname;
    this.phone = phone;
    this.email = email;
    this.socialAccounts = socialAccounts;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(final String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public List<Social> getSocialAccounts() {
    return socialAccounts;
  }

  public void setSocialAccounts(final List<Social> socialAccounts) {
    this.socialAccounts = socialAccounts;
  }
}
