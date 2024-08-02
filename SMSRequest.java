package com.amazon.hfchotel.test.communicationManagement.bo;

import com.amazon.hfchotel.test.communicationManagement.enums.RequestType;

public class SMSRequest extends Request {

    private String phoneNumber;
    private RequestType requestType = RequestType.SMS;

    public SMSRequest(final String requestId, final RequestType requestType,
        final String requestMessage,
        final String phoneNumber) {

        super(requestId, requestType, requestMessage);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    @Override
    public RequestType getRequestType() {

        return requestType;
    }

    @Override
    public void setRequestType(final RequestType requestType) {

        this.requestType = requestType;
    }
}
