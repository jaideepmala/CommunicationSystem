package com.amazon.hfchotel.test.communicationManagement.service.request;

import com.amazon.hfchotel.test.communicationManagement.bo.Provider;
import com.amazon.hfchotel.test.communicationManagement.bo.Request;

public interface IRequestService {

    void processRequest(Request request, String providerId, String accountId);

}
