package com.amazon.hfchotel.test.communicationManagement.service.provider;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.amazon.hfchotel.test.communicationManagement.bo.Provider;
import com.amazon.hfchotel.test.communicationManagement.exceptions.ProviderNotFoundException;

public class ProviderService implements IProviderService {

    private Map<String, Provider> providers = new HashMap<>();

    @Override
    public void addProvider(final Provider provider) {

        providers.putIfAbsent(provider.getProviderId(), provider);
    }

    @Override
    public Provider getProvider(final String providerId) {

        final Provider provider = providers.get(providerId);
        if (Objects.nonNull(provider)) {
            return provider;
        } else {
            throw new ProviderNotFoundException("Provider not found with providerID " + providerId);
        }
    }

    @Override
    public void updateState(final String providerId, final boolean active) {

        final Provider provider = providers.get(providerId);
        if (Objects.nonNull(provider)) {
            provider.setActive(active);
        }
    }

    @Override
    public void updateProvider(final Provider provider) {

        if (Objects.nonNull(provider.getProviderId())) {
            Provider existingProvider = providers.get(provider.getProviderId());
            if (Objects.nonNull(existingProvider)) {
                providers.put(existingProvider.getProviderId(), provider);
            }
        }
    }


}
