package com.stoups.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.stoups.configuration.Configuration;
import com.stoups.models.EPType;
import com.stoups.models.FilterPostFix;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by astouparenko on 4/11/2017.
 */
@Component
public class RequestBuilder {

    @Autowired
    Configuration conf;

    private static String MAIN_HTTP = "https://igdbcom-internet-game-database-v1.p.mashape.com/";

    private String queryUrl = "?";
    private GetRequest request;

    public void createGetRequest (EPType type) {
        request = addHeaders(Unirest.get(MAIN_HTTP + type.toString() + queryUrl));
    }

    private GetRequest addHeaders(GetRequest request) {
        return request
                .header("X-Mashape-Key", conf.getVgdbKey())
                .header("Accept", "application/json");
    }

    public RequestBuilder addFiltersMap (Map<FilterPostFix, String[]> filterMap) {
        if (filterMap != null) {
            //Applies every Filter to request (Entry Value should contain [{Field},{Value}])
            for (Map.Entry<FilterPostFix, String[]> entry : filterMap.entrySet()) {
                String[] filterFieldVal = entry.getValue();
                if (filterFieldVal.length == 2 && filterFieldVal[0] != null && filterFieldVal[1] != null) {
                    addFilter(filterFieldVal[0], entry.getKey(), filterFieldVal[1]);
                }
            }
        }

        return this;
    }


    public RequestBuilder addData (List<String> data){
        if (data != null) {
            add("fields", String.join(",", data));
        }
        return this;
    }


    public RequestBuilder addLimit (int limit){
        add("limit", limit);
        return this;
    }

    public RequestBuilder addOffset (int offset){
        add("offset", offset);
        return this;
    }

    public RequestBuilder addSearch (String q){
        add("search", q);
        return this;
    }



    public RequestBuilder addFields (String fields){
        add("fields", fields);
        return this;
    }

    public RequestBuilder sortbyDate (){
        add("order", "release_dates.date:desc");
        return this;
    }

    public RequestBuilder addFilter (String field, FilterPostFix type, String value) {
        queryUrl += "&filter[" + field + "][" + type.toString().toLowerCase() + "]=" + value;
        return this;
    }

    public RequestBuilder addFilter (String field, FilterPostFix type, int value) {
        queryUrl += "&filter[" + field + "][" + type.toString().toLowerCase() + "]=" + value;
        return this;
    }

    public RequestBuilder addFilter (String field, int type, int value) {
        queryUrl += "&filter[" + field + "][gt]=" + value;
        return this;
    }

    public <T> ArrayList<T> sendAndParseToList(ArrayList<T> someList, Class clazz) throws UnirestException{
        //Send the request and parse the response into a list of Games
        try {
            HttpResponse<JsonNode> response;

                response = request.asJson();

            if (response.getBody() != null && response.getBody().isArray()) {
                JSONArray arr = response.getBody().getArray();
                ObjectMapper objectMapper = new ObjectMapper();
                TypeFactory t = TypeFactory.defaultInstance();
                System.out.println(someList.getClass().toGenericString());
                someList = objectMapper.readValue(arr.toString(), t.constructCollectionType(ArrayList.class, clazz));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return someList;
    }

    private String add (String field, String value){
        return queryUrl += "&" + field + "=" +  value;
    }

    private String add (String field, int value){
        return queryUrl +=  "&" + field + "=" + value;
    }

    private String add (String field, double value){
        return queryUrl += "&" + field + "=" + value;
    }
}
