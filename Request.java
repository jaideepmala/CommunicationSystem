package com.amazon.hfchotel.test.communicationManagement.bo;

import com.amazon.hfchotel.test.communicationManagement.enums.RequestType;

public class Request {

    private String requestId;
    private RequestType requestType;
    private String requestMessage;

    public Request(final String requestId, final RequestType requestType,
        final String requestMessage) {

        this.requestId = requestId;
        this.requestType = requestType;
        this.requestMessage = requestMessage;
    }

    public String getRequestId() {

        return requestId;
    }

    public void setRequestId(final String requestId) {

        this.requestId = requestId;
    }

    public RequestType getRequestType() {

        return requestType;
    }

    public void setRequestType(final RequestType requestType) {

        this.requestType = requestType;
    }

    public String getRequestMessage() {

        return requestMessage;
    }

    public void setRequestMessage(final String requestMessage) {

        this.requestMessage = requestMessage;
    }
}
