package org.spotdraft.asana.service;

import org.spotdraft.asana.dto.AsanaTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirtableApiService {

    private final String airtableApiBaseUrl;
    private final String airtableApiBaseId;
    private final String airtableApiTableName;
    private final String airtableApiKey;
    private final RestTemplate restTemplate;

    @Autowired
    public AirtableApiService(@Value("${airtable.api.base-url}") String airtableApiBaseUrl,
                              @Value("${airtable.api.base-id}") String airtableApiBaseId,
                              @Value("${airtable.api.table-name}") String airtableApiTableName,
                              @Value("${airtable.api.api-key}") String airtableApiKey,
                              RestTemplate restTemplate) {
        this.airtableApiBaseUrl = airtableApiBaseUrl;
        this.airtableApiBaseId = airtableApiBaseId;
        this.airtableApiTableName = airtableApiTableName;
        this.airtableApiKey = airtableApiKey;
        this.restTemplate = restTemplate;
    }

    // Implement methods to interact with the Airtable API here
    // For example, you can implement a method to create a record in Airtable
    public void createRecord(AsanaTask airtableRecord) {
        // Your implementation here
        // Use restTemplate to make API requests to Airtable
    }
}
