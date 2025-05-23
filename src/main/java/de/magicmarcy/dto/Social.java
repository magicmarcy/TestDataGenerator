package de.magicmarcy.dto;

import de.magicmarcy.enums.Platform;

/**
 * Represents a social media account of a person.
 * This class contains the platform and the username of the account.
 *
 * @author magicmarcy
 */
public class Social {

  /** The social media platform. */
  private final Platform platform;

  /** The username of the account. */
  private final String username;

  /**
   * Default constructor for JSON deserialization.
   */
  public Social(Platform platform, String username) {
    this.platform = platform;
    this.username = username;
  }

  // Getter for each field

  public Platform getPlatform() {
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
