package com.amazon.hfchotel.test.communicationManagement.bo;

import java.util.Objects;

public class ProviderAccount {

    private String accountID;
    private String accountName;

    public ProviderAccount(final String accountID, final String accountName) {

        this.accountID = accountID;
        this.accountName = accountName;
    }

    public String getAccountID() {

        return accountID;
    }

    public void setAccountID(final String accountID) {

        this.accountID = accountID;
    }

    public String getAccountName() {

        return accountName;
    }

    public void setAccountName(final String accountName) {

        this.accountName = accountName;
    }

    @Override
    public boolean equals(final Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProviderAccount that = (ProviderAccount) o;
        return Objects.equals(accountID, that.accountID) && Objects.equals(accountName,
            that.accountName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(accountID, accountName);
    }
}
