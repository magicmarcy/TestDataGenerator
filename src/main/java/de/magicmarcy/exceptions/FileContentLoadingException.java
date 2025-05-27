package de.magicmarcy.exceptions;

/**
 * Exception thrown if there is an error while loading the names from the text files.
 *
 * @author magicmarcy
 */
public final class FileContentLoadingException extends RuntimeException {

  public FileContentLoadingException(String message, Throwable cause) {
    super(message, cause);
  }

  public FileContentLoadingException(String message) {
    super(message);
  }
}
