package org.spotdraft.asana.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spotdraft.asana.dto.AirtableRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AirtableDaoImpl implements AirtableDao {

    private final String AIRTABLE_API_URL = "https://api.airtable.com/v0/{baseId}/{tableName}";
    private final String AIRTABLE_API_KEY = "patrPB6LMAVclArUF.d5299bf1f841bb65f94b6b8d7d26f56c7e353f1c6c90dd4dc38e1bf6715c75ed"; 

    private RestTemplate restTemplate;

    @Autowired
    public AirtableDaoImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AirtableRecord createRecord(AirtableRecord record) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + AIRTABLE_API_KEY);
        headers.put("Content-Type", "application/json");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("fields", record.getFields());

        AirtableRecord createdRecord = restTemplate.postForObject(AIRTABLE_API_URL, requestBody, AirtableRecord.class, headers);
        return createdRecord;
    }

    @Override
    public List<AirtableRecord> createMultipleRecords(List<AirtableRecord> records) {
        // Logic to be implemented to create multiple records in Airtable (similar to createRecord method)
        // need to use batch API requests to create multiple records efficiently
        return null;
    }
    
        private  String apiKey;
        private  String airtableBaseUrl;
        private  RestTemplate restTemplate1;
        private  ObjectMapper objectMapper;

        public void AirtableDao(@Value("${airtable.api.key}") String apiKey,
                           @Value("${airtable.base.url}") String airtableBaseUrl,
                           RestTemplate restTemplate,
                           ObjectMapper objectMapper) {
            this.apiKey = apiKey;
            this.airtableBaseUrl = airtableBaseUrl;
            this.restTemplate = restTemplate;
            this.objectMapper = objectMapper;
        }

        public AirtableRecord createRecord(String baseId, String tableIdOrName, AirtableRecord record) {
            String url = String.format("%s/%s/%s", airtableBaseUrl, baseId, tableIdOrName);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + apiKey);
            HttpEntity<AirtableRecord> request = new HttpEntity<>(record, headers);
            
            AirtableRecord createdRecord = restTemplate.exchange(url, HttpMethod.POST, request, AirtableRecord.class).getBody();
            return createdRecord;
        }
}
