package org.spotdraft.asana.helper;

import org.spotdraft.asana.dto.AsanaTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class AsanaResponseHelper {

    private final ObjectMapper objectMapper;

    public AsanaResponseHelper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public AsanaTask parseAsanaTask(String asanaApiResponse) throws JsonProcessingException {
        JsonNode rootNode = objectMapper.readTree(asanaApiResponse);
        JsonNode taskNode = rootNode.get("data");
        return objectMapper.treeToValue(taskNode, AsanaTask.class);
    }
}
