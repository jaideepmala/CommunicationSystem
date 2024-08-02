package com.amazon.hfchotel.test.communicationManagement.service.processor;

import com.amazon.hfchotel.test.communicationManagement.bo.EmailRequest;
import com.amazon.hfchotel.test.communicationManagement.bo.Provider;
import com.amazon.hfchotel.test.communicationManagement.bo.ProviderAccount;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailRequestProcessor implements RequestProcessor<EmailRequest> {

    @Override
    public void process(final EmailRequest request, final Provider provider,
        final ProviderAccount providerAccount) {

        if (provider.isActive()) {
            log.info("Put email request in KAFKA topic" + request.getRequestId() + " "
                + provider.getProviderId() + " for provider account "
                + providerAccount.getAccountID());

        }
    }
}
