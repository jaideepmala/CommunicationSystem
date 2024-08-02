package com.amazon.hfchotel.test.communicationManagement.controller;

import javax.inject.Inject;

import com.amazon.hfchotel.test.communicationManagement.bo.Request;
import com.amazon.hfchotel.test.communicationManagement.service.request.IRequestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestController {

    private final IRequestService requestService;

    @Inject
    public RequestController(final IRequestService requestService) {

        this.requestService = requestService;
    }

    public void processRequest(Request request, String providerId, String accountId) {

        log.info("Process request called for request {} for provider {} for account {}", request.getRequestId(), providerId,accountId);
        requestService.processRequest(request, providerId, accountId);

    }
}
