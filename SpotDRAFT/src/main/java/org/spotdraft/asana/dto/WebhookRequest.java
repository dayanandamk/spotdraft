package org.spotdraft.asana.dto;

import lombok.Data;

@Data
public class WebhookRequest {

    private String targetUrl;
    private String resource;
    private String action;
}
