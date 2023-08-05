package org.spotdraft.asana.dao;

import org.spotdraft.asana.dto.AirtableRecord;
import java.util.List;

public interface AirtableDao {
    AirtableRecord createRecord(AirtableRecord record);

    List<AirtableRecord> createMultipleRecords(List<AirtableRecord> records);
}
