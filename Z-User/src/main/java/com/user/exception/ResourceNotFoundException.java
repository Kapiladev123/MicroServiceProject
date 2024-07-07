package com.user.exception;

/**
 * Exception class representing a resource not found error.
 * <p>
 * This class extends {@code RuntimeException}, indicating that it's an unchecked exception.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Default serial version UID for serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ResourceNotFoundException with a default message.
     */
    public ResourceNotFoundException() {
        super("Resource not found");
    }

    /**
     * Constructs a new ResourceNotFoundException with the specified message.
     *
     * @param message The detail message explaining the exception.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

