package de.magicmarcy.dto;

import de.magicmarcy.enums.CountryCode;
import de.magicmarcy.generator.Telephone;

/**
 * @author magicmarcy
 */
public class TelephoneDTO {
  private String countryPrefix;
  private String cityPrefix;
  private String number;

  public TelephoneDTO() {
    super();
  }

  public TelephoneDTO(String countryPrefix, String cityPrefix, String number) {
    this.countryPrefix = countryPrefix;
    this.cityPrefix = cityPrefix;
    this.number = number;
  }

  public String getCountryPrefix() {
    return countryPrefix;
  }

  public void setCountryPrefix(String countryPrefix) {
    this.countryPrefix = countryPrefix;
  }

  /**
   * Something special here form german telephone numbers. If you use the city prefix standalone (not as international)
   * you have to add a leading zero. Some other countries does have this as well (e.g. Austria, Italy), but not all. In Great Britain
   * the leading zero is used for local and international calls, France and Spain have other rules.
   * Atm we have no other countries than Germany and USA, so we just handle these two.
   * @return the city prefix with leading zero for german numbers, otherwise just the city prefix
   */
  public String getCityPrefix() {
    CountryCode countryCode = CountryCode.getCountryCode(this.countryPrefix);

    return switch (countryCode) {
      case GERMANY -> "0" + this.cityPrefix;
      case USA -> this.cityPrefix;
    };
  }

  public void setCityPrefix(String cityPrefix) {
    this.cityPrefix = cityPrefix;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String prettyPrint() {
    return this.countryPrefix + Telephone.SPACE + this.getCityPrefix() + Telephone.SPACE + this.number;
  }

  @Override
  public String toString() {
    return this.countryPrefix + this.cityPrefix + this.number;
  }
}
