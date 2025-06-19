package de.magicmarcy.dto;

import de.magicmarcy.enums.PlatformType;

/**
 * Represents a social media account of a person.
 * This class contains the platform and the username of the account.
 *
 * @author magicmarcy
 */
public class SocialDTO {

  /** The social media platform. */
  private final PlatformType platform;

  /** The username of the account. */
  private final String username;

  /**
   * Default constructor for JSON deserialization.
   */
  public SocialDTO(PlatformType platform, String username) {
    this.platform = platform;
    this.username = username;
  }

  // Getter for each field

  public PlatformType getPlatform() {
    return platform;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public String toString() {
    return "Social{" +
        "platform=" + platform +
        ", username='" + username + '\'' +
        '}';
  }
}
