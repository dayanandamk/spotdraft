package org.spotdraft.asana.helper;

import java.util.List;

import org.spotdraft.asana.dto.AirtableRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AirtableApiHelper {

    @Value("${airtable.api.base-url}")
    private String airtableBaseUrl;

    @Value("${airtable.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    
    

    public AirtableApiHelper(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Add methods to interact with the Airtable API here
    // For example, methods to create records, update records, etc.

    // Helper method to set common headers for Airtable API requests
    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

	public Object createRecordsRequest(List<AirtableRecord> records) {
		// TODO Auto-generated method stub
		return null;
	}
}
