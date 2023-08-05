package org.spotdraft.asana.controller;

import org.spotdraft.asana.dto.AsanaWebhookEvent;
import org.spotdraft.asana.service.AsanaIntegrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook/asana")
public class AsanaWebhookController {

    private final AsanaIntegrationService asanaIntegrationService;

    public AsanaWebhookController(AsanaIntegrationService asanaIntegrationService) {
        this.asanaIntegrationService = asanaIntegrationService;
    }

    @PostMapping
    public ResponseEntity<String> handleWebhookEvent(@RequestBody AsanaWebhookEvent event) {
        try {
            asanaIntegrationService.processWebhookEvent(event);
            return new ResponseEntity<>("Webhook event processed successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
