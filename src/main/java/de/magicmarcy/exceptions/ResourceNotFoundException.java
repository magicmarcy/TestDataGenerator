package de.magicmarcy.exceptions;

/**
 * Exception thromwn when the resource (e.g. the text files with names) is not found.
 *
 * @author magicmarcy
 */
public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ResourceNotFoundException(final String message) {
    super(message);
  }
}
