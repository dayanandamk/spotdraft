package org.spotdraft.asana.service;

import org.spotdraft.asana.dto.AsanaTask;
//import com.example.asanaairtableintegration.AsanaWebhookEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AsanaApiService {

    private final String asanaApiBaseUrl;
    private final String asanaApiAccessToken;
    private final RestTemplate restTemplate;

    @Autowired
    public AsanaApiService(@Value("${asana.api.base-url}") String asanaApiBaseUrl,
                           @Value("${asana.api.access-token}") String asanaApiAccessToken,
                           RestTemplate restTemplate) {
        this.asanaApiBaseUrl = asanaApiBaseUrl;
        this.asanaApiAccessToken = asanaApiAccessToken;
        this.restTemplate = restTemplate;
    }

    // Implement methods to interact with the Asana API here
    // For example, you can implement a method to get a task by its ID
    public AsanaTask getTaskById(int taskId) {
        // Your implementation here
        // Use restTemplate to make API requests to Asana
        return null;
    }
}
