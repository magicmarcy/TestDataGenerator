package de.magicmarcy.dto;

import de.magicmarcy.enums.CountryCode;

/**
 * DTO class representing an full address.
 *
 * @author magicmarcy
 */
public class AddressDTO {

  /** Street name and number */
  private String street;

  /** City name */
  private String city;

  /** State name */
  private String state;

  /** Zip code */
  private String zipCode;

  /** Country name */
  private CountryCode country;

  /**
   * Default constructor.
   */
  public AddressDTO() {
    super();
  }

  /**
   * Constructor to initialize all fields.
   *
   * @param street  Street name and number
   * @param city    City name
   * @param state   State name
   * @param zipCode Zip code
   * @param country Country name
   */
  public AddressDTO(String street, String city, String state, String zipCode, CountryCode country) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.country = country;
  }

  // Getter and Setter methods for each field

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public CountryCode getCountry() {
    return country;
  }

  public void setCountry(CountryCode country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "Address{" +
        "street='" + street + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", zipCode='" + zipCode + '\'' +
        ", country='" + country.name() + '\'' +
        '}';
  }
}
