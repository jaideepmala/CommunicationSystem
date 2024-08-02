package com.amazon.hfchotel.test.communicationManagement.exceptions;

public class ProviderNotFoundException extends RuntimeException{

    public ProviderNotFoundException(final String message, final Throwable cause) {

        super(message, cause);
    }

    public ProviderNotFoundException(final String message) {

        super(message);
    }
}
