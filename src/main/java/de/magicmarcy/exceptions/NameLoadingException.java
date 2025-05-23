package de.magicmarcy.exceptions;

/**
 * @author magicmarcy | 23.05.2025
 */
public class NameLoadingException extends RuntimeException {

  public NameLoadingException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
