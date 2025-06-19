package de.magicmarcy.dto;

import java.util.List;

/**
 * @author magicmarcy
 */
public class ContactDTO {

  private String name;
  private String surname;
  private String phone;
  private String email;
  private List<SocialDTO> socialAccounts;

  public ContactDTO() {
    super();
  }

  public ContactDTO(String name, String surname, String phone, String email, List<SocialDTO> socialAccounts) {
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

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<SocialDTO> getSocialAccounts() {
    return socialAccounts;
  }

  public void setSocialAccounts(List<SocialDTO> socialAccounts) {
    this.socialAccounts = socialAccounts;
  }
}
