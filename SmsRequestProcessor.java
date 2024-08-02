package com.amazon.hfchotel.test.communicationManagement.service.processor;

import com.amazon.hfchotel.test.communicationManagement.bo.Provider;
import com.amazon.hfchotel.test.communicationManagement.bo.ProviderAccount;
import com.amazon.hfchotel.test.communicationManagement.bo.SMSRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsRequestProcessor implements RequestProcessor<SMSRequest> {

    @Override
    public void process(SMSRequest request, final Provider provider,
        final ProviderAccount providerAccount) {

        if (provider.isActive()) {
            log.info("Put sms request in KAFKA topic" + request.getRequestId() + " "
                + provider.getProviderId() + " for provider account " + providerAccount
                .getAccountID());
        }
    }
}
