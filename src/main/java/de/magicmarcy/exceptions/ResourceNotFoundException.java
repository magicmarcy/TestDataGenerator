package de.magicmarcy.exceptions;

/**
 * @author magicmarcy | 23.05.2025
 */
public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(final String message) {
    super(message);
  }
}
