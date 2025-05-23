package de.magicmarcy.exceptions;

/**
 * Exception thrown if there is an error while loading the names from the text files.
 *
 * @author magicmarcy
 */
public class NameLoadingException extends RuntimeException {

  public NameLoadingException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public NameLoadingException(final String message) {
    super(message);
  }
}
