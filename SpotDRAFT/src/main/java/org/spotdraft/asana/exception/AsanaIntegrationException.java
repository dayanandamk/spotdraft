package org.spotdraft.asana.exception;

public class AsanaIntegrationException extends RuntimeException {

    public AsanaIntegrationException(String message) {
        super(message);
    }

    public AsanaIntegrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
