package com.amazon.hfchotel.test.communicationManagement.enums;

import lombok.Getter;

public enum RequestType {
    EMAIL("EMAIL"),
    SMS("SMS"),
    SOUNDBOX("SOUNDBOX");


    @Getter
    public final String request;
    RequestType(final String request) {
        this.request = request;
    }
}
