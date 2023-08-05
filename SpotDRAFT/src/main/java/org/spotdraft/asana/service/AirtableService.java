package org.spotdraft.asana.service;

import org.spotdraft.asana.dto.AirtableRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirtableService {
    private final String airtableBaseUrl;
    private final String airtableApiKey;
    private final RestTemplate restTemplate;

    public AirtableService(
            @Value("${airtable.base-url}") String airtableBaseUrl,
            @Value("${airtable.api-key}") String airtableApiKey
    ) {
        this.airtableBaseUrl = airtableBaseUrl;
        this.airtableApiKey = airtableApiKey;
        this.restTemplate = new RestTemplate();
    }

    public void createRecord(AirtableRecord record) {
        String url = airtableBaseUrl + "/{tableIdOrName}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + airtableApiKey);

        HttpEntity<AirtableRecord> requestEntity = new HttpEntity<>(record, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class,
                record.getTableIdOrName()
        );

        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to create record in Airtable");
        }
    }
}
