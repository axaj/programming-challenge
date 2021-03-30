package de.exxcellent.challenge;

import java.util.List;

public interface IDataSelector {
    public List<String> selectStringsByFieldName(String fieldName);
    public List<Integer> selectIntegersByFieldName(String fieldName);
}
