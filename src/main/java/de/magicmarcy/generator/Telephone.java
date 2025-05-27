package de.magicmarcy.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.enums.CountryCode;

/**
 * @author magicmarcy
 */
public final class Telephone {

  public static final int MINUIMUM_PREFIX_NUMBER = 200;
  public static final int MAXIMUM_PREFOX_NUMBER = 999;
  public static final int MINIMUM_NUMBER_VALUE = 111111;
  public static final int MAXIMUM_NUMBER_VALUE = 999999999;

  public static final String SPACE = " ";

  private Telephone() {
    // private constructor to prevent instantiation
  }

  public static TelephoneBuilder builder() {
    return new TelephoneBuilder();
  }

  public static final class TelephoneBuilder implements Generator<String> {
    private CountryCode countryCode = null;
    private int minimumPrefixNumber = MINUIMUM_PREFIX_NUMBER;
    private int maximumPrefixNumber = MAXIMUM_PREFOX_NUMBER;
    private int minimumNumberValue = MINIMUM_NUMBER_VALUE;
    private int maximumNumberValue = MAXIMUM_NUMBER_VALUE;

    public TelephoneBuilder countryCode(CountryCode countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    public TelephoneBuilder minimumPrefixNumber(int minimumPrefixNumber) {
      this.minimumPrefixNumber = minimumPrefixNumber;
      return this;
    }

    public TelephoneBuilder maximumPrefixNumber(int maximumPrefixNumber) {
      this.maximumPrefixNumber = maximumPrefixNumber;
      return this;
    }

    public TelephoneBuilder minimumNumberValue(int minimumNumberValue) {
      this.minimumNumberValue = minimumNumberValue;
      return this;
    }

    public TelephoneBuilder maximumNumberValue(int maximumNumberValue) {
      this.maximumNumberValue = maximumNumberValue;
      return this;
    }

    @Override
    public String buildOne() {
      return build(1).get(0);
    }

    @Override
    public List<String> build(int count) {
      List<String> resultList = new ArrayList<>(count);

      for (int i = 0; i < count; i++) {
        resultList.add(generateTelephoneNumber());
      }

      return resultList;
    }

    private String generateTelephoneNumber() {
      StringBuilder telephone = new StringBuilder();

      // Telephone country prefix
      if (this.countryCode == null) {
        telephone.append(pickRandomCountryCode().getTelephoneCode());
      } else {
        telephone.append(this.countryCode.getTelephoneCode());
      }

      telephone.append(SPACE);

      // Telephone prefix
      telephone.append(Number.builder().range(this.minimumPrefixNumber, this.maximumPrefixNumber).buildOne());

      telephone.append(SPACE);

      // Telephone number
      telephone.append(Number.builder().range(this.minimumNumberValue, this.maximumNumberValue).buildOne());

      return telephone.toString();
    }

    private CountryCode pickRandomCountryCode() {
      CountryCode[] enumConstants = CountryCode.class.getEnumConstants();

      return enumConstants[ThreadLocalRandom.current().nextInt(enumConstants.length)];
    }
  }
}
