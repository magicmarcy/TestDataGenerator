package de.magicmarcy.dto;

import de.magicmarcy.enums.Platform;

/**
 * @author magicmarcy | 23.05.2025
 */
public class Social {

  private final Platform platform;
  private final String username;

  public Social(Platform platform, String username) {
    this.platform = platform;
    this.username = username;
  }

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
