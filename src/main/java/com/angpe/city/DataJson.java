package com.angpe.city;

import java.util.*;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

public class DataJson {
    public List<String> City(){
        List<String> cities = new ArrayList<>();

        String url = "https://raw.githubusercontent.com/lutangar/cities.json/master/cities.json";
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);

        JsonParser springParser = JsonParserFactory.getJsonParser();
        List<Object> list = springParser.parseList(resp);

        for (Object o : list) {
            if (o instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) o;
                filterByCountry(map, "country", "ID", cities);
            }
        }
        return cities;
    }

    public void filterByCountry(Map<String, Object> map, String country, String id, List<String> cities){
        if (map.get(country).equals(id)){
            map.forEach((key, value) -> addCityNameToList(key, value, cities));
        }
    }

    public void addCityNameToList(String key, Object value, List<String> cities){
        if(key.equals("name"))  cities.add(value.toString());
    }
}
