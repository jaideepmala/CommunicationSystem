package com.amazon.hfchotel.test.communicationManagement.factory;

import com.amazon.hfchotel.test.communicationManagement.enums.RequestType;
import com.amazon.hfchotel.test.communicationManagement.exceptions.UndefinedRequestTypeException;
import com.amazon.hfchotel.test.communicationManagement.service.processor.EmailRequestProcessor;
import com.amazon.hfchotel.test.communicationManagement.service.processor.RequestProcessor;
import com.amazon.hfchotel.test.communicationManagement.service.processor.SmsRequestProcessor;

public class RequestProcessorFactory {

    public static RequestProcessor<?> getProcessor(RequestType requestType) {

        switch (requestType) {
            case EMAIL:
                return new EmailRequestProcessor();
            case SMS:
                return new SmsRequestProcessor();
            default:
                throw new UndefinedRequestTypeException(
                    "Undefined request type exception for " + requestType);
        }
    }
}
