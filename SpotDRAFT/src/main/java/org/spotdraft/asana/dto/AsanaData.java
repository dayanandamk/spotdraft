package org.spotdraft.asana.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AsanaData {
	
    private int id;
    private String name;
    private String assignee;
    private Date dueDate;
    private String description;

    @JsonProperty("resource_type")
    private String resourceType;

    @JsonProperty("resource_subtype")
    private String resourceSubtype;

}
