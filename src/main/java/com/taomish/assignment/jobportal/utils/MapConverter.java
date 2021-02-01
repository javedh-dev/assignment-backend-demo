package com.taomish.assignment.jobportal.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Converter(autoApply = true)
public class MapConverter implements AttributeConverter<Map<String, Object>, String> {

    @Autowired
    ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        String mapToJSON = null;
        try{
            mapToJSON = mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Error while writing json.", e);
        }
        return mapToJSON;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        Map<String, Object> jsonToMap = null;
        try{
            jsonToMap = mapper.readValue(dbData,Map.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().log(Level.SEVERE, "Error while mapping json.", e);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().log(Level.SEVERE, "Error while processing json.", e);
        }
        return jsonToMap;
    }
}
