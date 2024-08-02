package com.amazon.hfchotel.test.communicationManagement.service.processor;

import com.amazon.hfchotel.test.communicationManagement.bo.Provider;
import com.amazon.hfchotel.test.communicationManagement.bo.ProviderAccount;
import com.amazon.hfchotel.test.communicationManagement.bo.Request;

public interface RequestProcessor<T extends Request> {

    void process(T request, Provider provider, ProviderAccount providerAccount);
}
