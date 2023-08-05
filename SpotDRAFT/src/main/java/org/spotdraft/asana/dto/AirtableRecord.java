package org.spotdraft.asana.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirtableRecord {
	
    private int id;
    private String createdTime;
    private Map<String, Object> fields;
    private String tableIdOrName;
}
