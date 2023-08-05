package org.spotdraft.asana.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirtableRow {
	
    private int taskId;
    private String name;
    private String assignee;
    private Date dueDate;
    private String description;
}
