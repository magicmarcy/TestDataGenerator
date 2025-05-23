package de.magicmarcy.dto;

/**
 * DTO class representing an full address.
 *
 * @author magicmarcy
 */
public class Address {

  /** Street name and number */
  private String street;

  /** City name */
  private String city;

  /** State name */
  private String state;

  /** Zip code */
  private String zipCode;

  /** Country name */
  private String country;

  /**
   * Default constructor.
   */
  public Address() {
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
  public Address(final String street, final String city, final String state, final String zipCode, final String country) {
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

  public void setStreet(final String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(final String state) {
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(final String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(final String country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "Address{" +
        "street='" + street + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", zipCode='" + zipCode + '\'' +
        ", country='" + country + '\'' +
        '}';
  }
}
