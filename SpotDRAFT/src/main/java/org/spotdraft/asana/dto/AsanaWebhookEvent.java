package org.spotdraft.asana.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AsanaWebhookEvent {
	// @Id
	private int id;
	private String resource;
	private String action;
	private AsanaData data;

	@JsonProperty("parent")
	private AsanaData parentData;

}
