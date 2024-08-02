package com.amazon.hfchotel.test.communicationManagement.controller;

import javax.inject.Inject;

import com.amazon.hfchotel.test.communicationManagement.bo.Provider;
import com.amazon.hfchotel.test.communicationManagement.service.provider.IProviderService;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProviderController {

    private IProviderService providerService;

    @Inject
    public ProviderController(final IProviderService providerService) {

        this.providerService = providerService;
    }

    public void addProvider(@NonNull final Provider provider) {

        log.info("Add Provider endpoint called for providerId {}", provider.getProviderId());
        providerService.addProvider(provider);
    }

    public Provider getProvider(@NonNull final String providerId) {

        log.info("Get Provider endpoint called for providerId {}", providerId);
        return providerService.getProvider(providerId);
    }

    public void updateState(String providerId, boolean active) {

        log.info("Update Provider state endpoint called for providerId {} with state {}",
            providerId, active);
        providerService.updateState(providerId, active);
    }

    public void updateProvider(@NonNull final Provider provider) {

        log.info("Update Provider endpoint called for providerId {}", provider.getProviderId());
        providerService.updateProvider(provider);
    }
}
