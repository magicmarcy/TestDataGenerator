package de.magicmarcy.enums;

/**
 * Enum representing just a few countries to choose for an {@link de.magicmarcy.dto.Address} object
 *
 * @author magicmarcy
 */
public enum Country {
  FRANCE("+33"),
  USA("+1"),
  CHINA("+86"),
  SPAIN("+34"),
  ITALY("+39"),
  TURKEY("+90"),
  UK("+44"),
  GERMANY("+49"),
  RUSSIA("+7"),
  MALAYSIA("+60"),
  MEXICO("+52"),
  AUSTRIA("+43"),
  UKRAINE("+380"),
  THAILAND("+66"),
  SAUDIA_ARABIA("+966"),
  GREECE("+30"),
  CANADA("+1"),
  POLAND("+48"),
  NETHERLANDS("+31"),
  BELGIUM("+32"),
  SWITZERLAND("+41"),
  BRAZIL("+55"),
  ARGENTINA("+54"),
  SOUTH_AFRICA("+27"),
  JAPAN("+81"),
  SOUTH_KOREA("+82"),
  AUSTRALIA("+61"),
  NEW_ZEALAND("+64"),
  PHILIPPINES("+63"),
  VIETNAM("+84"),
  INDONESIA("+62"),
  SINGAPORE("+65"),
  HONG_KONG("+852");

  private final String telephoneCode;

  Country(String telephoneCode) {
    this.telephoneCode = telephoneCode;
  }

  public String getTelephoneCode() {
    return telephoneCode;
  }
}
