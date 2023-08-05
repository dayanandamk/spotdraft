package org.spotdraft.asana.exception;

public class AirtableIntegrationException extends RuntimeException {

    public AirtableIntegrationException(String message) {
        super(message);
    }

    public AirtableIntegrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
