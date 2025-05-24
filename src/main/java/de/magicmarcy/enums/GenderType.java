package de.magicmarcy.enums;

/**
 * Enum representing the gender to choose a name gender-specific name.
 *
 * @author magicmarcy
 */
public enum GenderType {
  MALE("male"),
  FEMALE("female");

  private final String fileNamePart;

  GenderType(String fileNamePart) {
    this.fileNamePart = fileNamePart;
  }

  public String getFileNamePart() {
    return fileNamePart;
  }
}
