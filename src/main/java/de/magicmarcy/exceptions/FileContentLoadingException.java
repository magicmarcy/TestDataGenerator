package de.magicmarcy.exceptions;

/**
 * Exception thrown if there is an error while loading the names from the text files.
 *
 * @author magicmarcy
 */
public class FileContentLoadingException extends RuntimeException {

  public FileContentLoadingException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public FileContentLoadingException(final String message) {
    super(message);
  }
}
