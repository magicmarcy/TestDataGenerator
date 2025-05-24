package de.magicmarcy.enums;

/**
 * Enum representing various social media platforms and their URLs.
 *
 * @author magicmarcy
 */
public enum PlatformType {
  FACEBOOK("Facebook", "https://www.facebook.com/"),
  TWITTER("Twitter", "https://twitter.com/"),
  INSTAGRAM("Instagram", "https://www.instagram.com/"),
  LINKEDIN("LinkedIn", "https://www.linkedin.com/"),
  GITHUB("GitHub", "https://github.com/"),
  YOUTUBE("YouTube", "https://www.youtube.com/"),
  TIKTOK("TikTok", "https://www.tiktok.com/"),
  SNAPCHAT("Snapchat", "https://www.snapchat.com/");

  private final String name;
  private final String url;

  PlatformType(final String name, final String url) {
    this.name = name;
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public static String getProfileUrl(final PlatformType platform, final String username) {
    if (platform.url.contains("%s")) {
      return String.format(platform.url, username);
    } else {
      return switch (platform) {
        case FACEBOOK -> platform.url + username;
        case TWITTER -> platform.url + username;
        case INSTAGRAM -> platform.url + username;
        case LINKEDIN -> platform.url + "in/" + username;
        case GITHUB -> platform.url + username;
        case YOUTUBE -> platform.url + "@" + username;
        case TIKTOK -> platform.url + "@" + username;
        case SNAPCHAT -> platform.url + "add/" + username;
      };
    }
  }
}
