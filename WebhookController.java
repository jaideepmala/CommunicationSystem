package com.amazon.hfchotel.test.communicationManagement.controller;

import com.amazon.hfchotel.test.communicationManagement.bo.DeliveryStatusPayload;
import com.amazon.hfchotel.test.communicationManagement.service.webhook.IWebhookService;
import com.amazon.hfchotel.test.communicationManagement.service.webhook.WebhookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebhookController {

   private IWebhookService webhookService;

    public WebhookController(final IWebhookService webhookService) {

        this.webhookService = webhookService;
    }


    public void processWebhook(final DeliveryStatusPayload deliveryStatusPayload){
        log.info("processWebhook called for request {}", deliveryStatusPayload.getRequestId());
        webhookService.processWebhook(deliveryStatusPayload);
    }



}
