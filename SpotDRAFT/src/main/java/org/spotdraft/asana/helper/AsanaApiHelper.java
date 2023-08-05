package org.spotdraft.asana.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AsanaApiHelper {

    @Value("${asana.api.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public AsanaApiHelper(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Add methods for API authentication and request handling here
}

