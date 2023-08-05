package org.spotdraft.asana.helper;

import org.spotdraft.asana.dto.AirtableRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class AirtableResponseHelper {

    private final ObjectMapper objectMapper;

    public AirtableResponseHelper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public AirtableRecord parseAirtableRecord(String airtableApiResponse) throws JsonProcessingException {
        JsonNode rootNode = objectMapper.readTree(airtableApiResponse);
        JsonNode recordsNode = rootNode.get("records");
        if (recordsNode.isArray() && recordsNode.size() > 0) {
            JsonNode recordNode = recordsNode.get(0);
            return objectMapper.treeToValue(recordNode, AirtableRecord.class);
        }
        return null;
    }
}
