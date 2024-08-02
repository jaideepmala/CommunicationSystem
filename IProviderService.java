package com.amazon.hfchotel.test.communicationManagement.service.provider;

import com.amazon.hfchotel.test.communicationManagement.bo.Provider;

public interface IProviderService {

    void addProvider(final Provider provider);

    Provider getProvider(final String providerId);

    void updateState(String providerId, boolean active);

    void updateProvider(Provider provider);
}
