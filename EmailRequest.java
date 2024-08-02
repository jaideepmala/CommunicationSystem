package com.amazon.hfchotel.test.communicationManagement.bo;

import com.amazon.hfchotel.test.communicationManagement.enums.RequestType;

public class EmailRequest extends Request {

    private String sender;
    private String receiver;

    private String subject;
    private RequestType requestType = RequestType.EMAIL;

    public EmailRequest(final String requestId, final RequestType requestType,
        final String requestMessage, final String sender,
        final String receiver, final String subject) {

        super(requestId, requestType, requestMessage);
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
    }

    public String getSender() {

        return sender;
    }

    public void setSender(final String sender) {

        this.sender = sender;
    }

    public String getReceiver() {

        return receiver;
    }

    public void setReceiver(final String receiver) {

        this.receiver = receiver;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(final String subject) {

        this.subject = subject;
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
