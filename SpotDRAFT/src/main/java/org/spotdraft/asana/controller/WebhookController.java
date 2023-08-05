package org.spotdraft.asana.controller;

import org.spotdraft.asana.dto.AsanaWebhookEvent;
import org.spotdraft.asana.dto.AirtableRecord;
import org.spotdraft.asana.service.AirtableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {
    private final AirtableService airtableService;

    @Autowired
    public WebhookController(AirtableService airtableService) {
        this.airtableService = airtableService;
    }

    @PostMapping("/asana")
    public ResponseEntity<Void> handleAsanaWebhookEvent(@RequestBody AsanaWebhookEvent event) {
        AirtableRecord record = createAirtableRecordFromAsanaEvent(event);
        airtableService.createRecord(record);
        return ResponseEntity.ok().build();
    }

    private AirtableRecord createAirtableRecordFromAsanaEvent(AsanaWebhookEvent event) {
        // Logic to convert AsanaWebhookEvent to AirtableRecord
        // Implementing this based on our mapping requirements
        AirtableRecord record = new AirtableRecord(0, null, null, null);
        // Set the values for the record from the AsanaWebhookEvent
        // For example, record.setField("Name", event.getName());
        return record;
    }
}
