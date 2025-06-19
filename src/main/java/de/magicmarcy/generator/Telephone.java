package de.magicmarcy.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.magicmarcy.dto.TelephoneDTO;
import de.magicmarcy.enums.CountryCode;

/**
 * @author magicmarcy
 */
public final class Telephone {

  /** The default minimum prefix number for the telephone number. */
  public static final int MINUIMUM_PREFIX_NUMBER = 200;

  /** The default maximum prefix number for the telephone number. */
  public static final int MAXIMUM_PREFOX_NUMBER = 999;

  /** The default minimum value for the telephone number. */
  public static final int MINIMUM_NUMBER_VALUE = 111111;

  /** The default maximum value for the telephone number. */
  public static final int MAXIMUM_NUMBER_VALUE = 999999999;

  /** A space character used to separate parts of the telephone number. */
  public static final String SPACE = " ";

  /**
   * Default constructor to prevent instantiation.
   */
  private Telephone() {
    // private constructor to prevent instantiation
  }

  /**
   * Creates a new builder for generating random telephone numbers.
   * @return a new instance of {@link TelephoneBuilder}
   */
  public static TelephoneBuilder builder() {
    return new TelephoneBuilder();
  }

  /**
   * Builder class for generating random telephone numbers.
   */
  public static final class TelephoneBuilder implements Generator<TelephoneDTO> {

    /** The country code for the telephone number. */
    private CountryCode countryCode = null;

    /** The minimum prefix number for the telephone number. */
    private int minimumPrefixNumber = MINUIMUM_PREFIX_NUMBER;

    /** The maximum prefix number for the telephone number. */
    private int maximumPrefixNumber = MAXIMUM_PREFOX_NUMBER;

    /** The minimum value for the telephone number. */
    private int minimumNumberValue = MINIMUM_NUMBER_VALUE;

    /** The maximum value for the telephone number. */
    private int maximumNumberValue = MAXIMUM_NUMBER_VALUE;

    /**
     * Sets the country code for the telephone number.
     * @param countryCode the country code to use
     * @return this builder
     */
    public TelephoneBuilder countryCode(CountryCode countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Sets the minimum prefix number for the telephone number.
     * @param minimumPrefixNumber the minimum prefix number
     * @return this builder
     */
    public TelephoneBuilder minimumPrefixNumber(int minimumPrefixNumber) {
      this.minimumPrefixNumber = minimumPrefixNumber;
      return this;
    }

    /**
     * Sets the maximum prefix number for the telephone number.
     * @param maximumPrefixNumber the maximum prefix number
     * @return this builder
     */
    public TelephoneBuilder maximumPrefixNumber(int maximumPrefixNumber) {
      this.maximumPrefixNumber = maximumPrefixNumber;
      return this;
    }

    /**
     * Sets the minimum value for the telephone number.
     * @param minimumNumberValue the minimum value for the telephone number
     * @return this builder
     */
    public TelephoneBuilder minimumNumberValue(int minimumNumberValue) {
      this.minimumNumberValue = minimumNumberValue;
      return this;
    }

    /**
     * Sets the maximum value for the telephone number.
     * @param maximumNumberValue the maximum value for the telephone number
     * @return this builder
     */
    public TelephoneBuilder maximumNumberValue(int maximumNumberValue) {
      this.maximumNumberValue = maximumNumberValue;
      return this;
    }

    /**
     * Generates a single random telephone number.
     * @return a TelephoneDTO object containing the generated telephone number
     */
    @Override
    public TelephoneDTO buildOne() {
      return build(1).get(0);
    }

    /**
     * Generates a list of random telephone numbers based on the specified count.
     * @param count the number of telephone numbers to generate
     * @return a list of TelephoneDTO objects containing the generated telephone numbers
     */
    @Override
    public List<TelephoneDTO> build(int count) {
      List<TelephoneDTO> resultList = new ArrayList<>(count);

      for (int i = 0; i < count; i++) {
        resultList.add(generateTelephoneNumber());
      }

      return resultList;
    }

    /**
     * Generates a random telephone number based on the provided parameters.
     * @return a TelephoneDTO containing the generated telephone number
     */
    private TelephoneDTO generateTelephoneNumber() {
      TelephoneDTO telephone = new TelephoneDTO();

      // Telephone country prefix
      if (this.countryCode == null) {
        telephone.setCountryPrefix(pickRandomCountryCode().getTelephoneCode());
      } else {
        telephone.setCountryPrefix(this.countryCode.getTelephoneCode());
      }

      // Telephone prefix
      telephone.setCityPrefix("" + Number.builder().range(this.minimumPrefixNumber, this.maximumPrefixNumber).buildOne());

      // Telephone number
      telephone.setNumber("" + Number.builder().range(this.minimumNumberValue, this.maximumNumberValue).buildOne());

      return telephone;
    }

    /**
     * Picks a random country code from the available CountryCode enum constants.
     * @return a randomly selected CountryCode
     */
    private CountryCode pickRandomCountryCode() {
      CountryCode[] enumConstants = CountryCode.class.getEnumConstants();

      return enumConstants[ThreadLocalRandom.current().nextInt(enumConstants.length)];
    }
  }
}
