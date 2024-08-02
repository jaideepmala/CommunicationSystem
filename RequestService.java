package com.amazon.hfchotel.test.communicationManagement.service.request;

import java.util.Optional;

import javax.inject.Inject;

import com.amazon.hfchotel.test.communicationManagement.bo.Provider;
import com.amazon.hfchotel.test.communicationManagement.bo.ProviderAccount;
import com.amazon.hfchotel.test.communicationManagement.bo.Request;
import com.amazon.hfchotel.test.communicationManagement.enums.RequestType;
import com.amazon.hfchotel.test.communicationManagement.factory.RequestProcessorFactory;
import com.amazon.hfchotel.test.communicationManagement.service.processor.RequestProcessor;
import com.amazon.hfchotel.test.communicationManagement.service.provider.IProviderService;
import com.amazon.hfchotel.test.communicationManagement.service.request.IRequestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestService implements IRequestService {

    private final IProviderService providerService;

    @Inject
    public RequestService(final IProviderService providerService) {

        this.providerService = providerService;
    }

    @Override
    public void processRequest(final Request request, final String providerId,
        final String accountId) {

        final RequestType requestType = request.getRequestType();
        RequestProcessor<Request> processor = (RequestProcessor<Request>) RequestProcessorFactory.getProcessor(
            requestType);
        Provider provider = providerService.getProvider(providerId);
        Optional<ProviderAccount> providerAccount = provider.getProviderAccountList().stream()
            .filter(account -> {
                return accountId.equals(account.getAccountID());
            }).findFirst();
        processor.process(request, provider, providerAccount.get());

    }
}
