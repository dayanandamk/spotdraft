package org.spotdraft.asana.dto;

import lombok.Data;

@Data
public class WebhookResponse {

    private int id;
    private String active;
    private String targetUrl;
    private String resource;
    private String action;

}
