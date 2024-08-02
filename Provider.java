package com.amazon.hfchotel.test.communicationManagement.bo;

import java.util.List;
import java.util.Objects;

public class Provider {

    private String providerId;
    private String providerName;
    private List<ProviderAccount> providerAccountList;
    private boolean isActive;

    public Provider(final String providerId, final String providerName,
        final List<ProviderAccount> providerAccountList, final boolean isActive) {

        this.providerId = providerId;
        this.providerName = providerName;
        this.providerAccountList = providerAccountList;
        this.isActive = isActive;
    }

    public String getProviderId() {

        return providerId;
    }

    public void setProviderId(final String providerId) {

        this.providerId = providerId;
    }

    public String getProviderName() {

        return providerName;
    }

    public void setProviderName(final String providerName) {

        this.providerName = providerName;
    }

    public List<ProviderAccount> getProviderAccountList() {

        return providerAccountList;
    }

    public void setProviderAccountList(
        final List<ProviderAccount> providerAccountList) {

        this.providerAccountList = providerAccountList;
    }

    public boolean isActive() {

        return isActive;
    }

    public void setActive(final boolean active) {

        isActive = active;
    }

    @Override
    public boolean equals(final Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Provider provider = (Provider) o;
        return Objects.equals(providerId, provider.providerId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(providerId);
    }
}
