package org.spotdraft.asana.service;

import org.spotdraft.asana.dto.AsanaWebhookEvent;
import org.spotdraft.asana.dto.AsanaTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsanaWebhookService {

    private final AsanaApiService asanaApiService;
    private final AirtableApiService airtableApiService;

    @Autowired
    public AsanaWebhookService(AsanaApiService asanaApiService, AirtableApiService airtableApiService) {
        this.asanaApiService = asanaApiService;
        this.airtableApiService = airtableApiService;
    }

    public void processAsanaWebhookEvent(AsanaWebhookEvent webhookEvent) {
        // Fetching the task details from Asana using the webhook event
        int taskId = webhookEvent.getId();
        AsanaTask task = asanaApiService.getTaskById(taskId);

        // Map AsanaTask to AirtableRecord and create the record in Airtable
        AsanaTask airtableRecord = mapAsanaTaskToAirtableRecord(task);
        airtableApiService.createRecord(airtableRecord);
    }

    private AsanaTask mapAsanaTaskToAirtableRecord(AsanaTask asanaTask) {
        // Your mapping logic from AsanaTask to AirtableRecord goes here
        // Map the task details to the respective columns in Airtable
        return null;
    }
}
