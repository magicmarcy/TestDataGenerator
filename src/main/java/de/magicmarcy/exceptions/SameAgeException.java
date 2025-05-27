package de.magicmarcy.exceptions;

/**
 * Exception thrown when the minimum and maximum age (number of years to limt the random birth dates) are the same.
 *
 * @author magicmarcy
 */
public final class SameAgeException extends RuntimeException {

  public SameAgeException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public SameAgeException(final String message) {
    super(message);
  }
}
