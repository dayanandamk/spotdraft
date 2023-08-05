package org.spotdraft.asana.service;

import org.spotdraft.asana.dto.AsanaTask;
import org.spotdraft.asana.dto.AsanaWebhookEvent;
import org.spotdraft.asana.model.TaskWebhook;
import org.spotdraft.asana.repository.TaskWebhookRepository;
import org.spotdraft.asana.helper.AsanaApiHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AsanaIntegrationService {

    private final AsanaApiHelper asanaApiHelper;
    private final TaskWebhookRepository taskWebhookRepository;

    @Value("${asana.api.webhook.url}")
    private String webhookUrl;

    @Value("${asana.api.pat}")
    private String personalAccessToken;

    public AsanaIntegrationService(AsanaApiHelper asanaApiHelper, TaskWebhookRepository taskWebhookRepository) {
        this.asanaApiHelper = asanaApiHelper;
        this.taskWebhookRepository = taskWebhookRepository;
    }

	public void processWebhookEvent(AsanaWebhookEvent event) {
		// TODO Auto-generated method stub
		
	}

    // Adding methods to set up and manage webhooks here

    // Adding methods to receive and process webhook events here

    // Adding methods to interact with Asana API to retrieve tasks and task details here
}

