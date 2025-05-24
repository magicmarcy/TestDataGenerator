package de.magicmarcy.enums;

/**
 * Enum representing just a few countries to choose for an {@link de.magicmarcy.dto.Address} object
 *
 * @author magicmarcy
 */
public enum CountryCode {
  GERMANY("+49", "de"),
  USA("+1", "en");

  private final String telephoneCode;
  private final String foldername;

  CountryCode(String telephoneCode, String foldername) {
    this.telephoneCode = telephoneCode;
    this.foldername = foldername;
  }

  public String getTelephoneCode() {
    return telephoneCode;
  }

  public String getFoldername() {
    return foldername;
  }
}
