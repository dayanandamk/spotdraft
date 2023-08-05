package org.spotdraft.asana.controller;

import org.spotdraft.asana.service.AirtableIntegrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airtable")
public class AirtableController {

    private final AirtableIntegrationService airtableIntegrationService;

    public AirtableController(AirtableIntegrationService airtableIntegrationService) {
        this.airtableIntegrationService = airtableIntegrationService;
    }

    @PostMapping("/sync")
    public ResponseEntity<String> syncAsanaTasksToAirtable() {
        try {
            airtableIntegrationService.syncAsanaTasksToAirtable();
            return new ResponseEntity<>("Asana tasks synced to Airtable successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
