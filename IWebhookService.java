package com.amazon.hfchotel.test.communicationManagement.service.webhook;

import com.amazon.hfchotel.test.communicationManagement.bo.DeliveryStatusPayload;

public interface IWebhookService {
    void processWebhook(final DeliveryStatusPayload deliveryStatusPayload);

}
