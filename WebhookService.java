package com.amazon.hfchotel.test.communicationManagement.service.webhook;

import java.sql.SQLException;

import javax.inject.Inject;

import com.amazon.hfchotel.test.communicationManagement.bo.DeliveryStatusPayload;
import com.amazon.hfchotel.test.communicationManagement.bo.Request;
import com.amazon.hfchotel.test.communicationManagement.dao.RequestDAO;
import com.amazon.hfchotel.test.communicationManagement.enums.DeliveryStatus;
import com.amazon.hfchotel.test.communicationManagement.service.provider.IProviderService;
import com.amazon.hfchotel.test.communicationManagement.service.request.IRequestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebhookService implements IWebhookService {

    private final IRequestService requestService;
    private final IProviderService providerService;
    private final RequestDAO requestDAO;

    @Inject
    public WebhookService(final IRequestService requestService,
        final IProviderService providerService, final RequestDAO requestDAO) {

        this.requestService = requestService;
        this.providerService = providerService;
        this.requestDAO = requestDAO;
    }

    @Override
    public void processWebhook(final DeliveryStatusPayload deliveryStatusPayload) {

        log.info("Webhook callback for {}", deliveryStatusPayload.getRequestId());
        if (deliveryStatusPayload.getDeliveryStatus().equals(DeliveryStatus.DELIVERED)) {
            log.info("Webhook callback for {} delivered sucessfully",
                deliveryStatusPayload.getRequestId());
        } else {
            log.info("Webhook callback for {} delivery failed. Push to kafka again",
                deliveryStatusPayload.getRequestId());
            Request request = null;
            try {
                request = requestDAO.getRequestById(deliveryStatusPayload.getRequestId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            requestService.processRequest(request, deliveryStatusPayload.getProviderId(),
                deliveryStatusPayload.getAccountId());
        }
    }
}
