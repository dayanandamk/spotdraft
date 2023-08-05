package org.spotdraft.asana.helper;

import org.spotdraft.asana.dto.AirtableRecord;
import org.spotdraft.asana.model.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AirtableHelper {

    @Value("${airtable.api.key}")
    private String apiKey;

    @Value("${airtable.base.id}")
    private String baseId;

    @Value("${airtable.table.name}")
    private String tableName;

    private final RestTemplate restTemplate;

    public AirtableHelper(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object createRecord(Task task) {
        String url = "https://api.airtable.com/v0/" + baseId + "/" + tableName;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        AirtableRecord record = new AirtableRecord(0, url, null, url);
        // Mapping the Task object to the AirtableRecord object
        // Setting the fields of the AirtableRecord using the Task data

        HttpEntity<AirtableRecord> requestEntity = new HttpEntity<>(record, headers);
        AirtableRecord createdRecord = restTemplate.exchange(url, HttpMethod.POST, requestEntity, AirtableRecord.class)
                .getBody();
        return createdRecord.getId();
    }

    // Adding methods for updating and deleting records from Airtable if needed

}
