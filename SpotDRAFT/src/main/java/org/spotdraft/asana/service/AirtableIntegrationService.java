package org.spotdraft.asana.service;

import org.spotdraft.asana.exception.IntegrationException;
import org.spotdraft.asana.helper.AirtableApiHelper;
import org.spotdraft.asana.dto.AirtableRecord;
import org.spotdraft.asana.dto.AsanaTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirtableIntegrationService {

    private final RestTemplate restTemplate;
    private final AirtableApiHelper airtableApiHelper;
    private final String airtableBaseUrl;
    private final String airtableApiKey;
    private final String airtableBaseId;
    private final String airtableTableId;

    public AirtableIntegrationService(RestTemplate restTemplate, AirtableApiHelper airtableApiHelper,
                                      @Value("${airtable.base.url}") String airtableBaseUrl,
                                      @Value("${airtable.api.key}") String airtableApiKey,
                                      @Value("${airtable.base.id}") String airtableBaseId,
                                      @Value("${airtable.table.id}") String airtableTableId) {
        this.restTemplate = restTemplate;
        this.airtableApiHelper = airtableApiHelper;
        this.airtableBaseUrl = airtableBaseUrl;
        this.airtableApiKey = airtableApiKey;
        this.airtableBaseId = airtableBaseId;
        this.airtableTableId = airtableTableId;
    }

    public void createAsanaTaskRecord(AsanaTask asanaTask) {
        AirtableRecord airtableRecord = mapAsanaTaskToAirtableRecord(asanaTask);
        List<AirtableRecord> records = new ArrayList<>();
        records.add(airtableRecord);

        String url = String.format("%s/%s/%s", airtableBaseUrl, airtableBaseId, airtableTableId);
        try {
            restTemplate.postForObject(url, airtableApiHelper.createRecordsRequest(records), String.class);
        } catch (Exception e) {
            throw new IntegrationException("Error while creating record in Airtable.");
        }
    }

    private AirtableRecord mapAsanaTaskToAirtableRecord(AsanaTask asanaTask) {
		return null;
        // Performing the mapping from AsanaTask to AirtableRecord here
        // Map Task ID, Name, Assignee, Due Date, and Description accordingly
        // Returning the AirtableRecord object
    }

	public void syncAsanaTasksToAirtable() {
		// TODO Auto-generated method stub
		
	}
}
 
