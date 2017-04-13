package com.stoups.services;

import com.stoups.models.EPType;
import com.stoups.models.FilterPostFix;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;

/**
 * Created by astouparenko on 4/11/2017.
 */
public class RequestBuilder {

    private static String MAIN_HTTP = "https://igdbcom-internet-game-database-v1.p.mashape.com/";

    private String queryUrl = "?";

    public GetRequest createGetRequest (EPType type) {
        return addHeaders(Unirest.get(MAIN_HTTP + type.toString() + queryUrl));
    }

    private GetRequest addHeaders(GetRequest request) {
        return request
                .header("X-Mashape-Key", "eHRzhjr2WxmshTz5Knpx7qHrHxSKp1F9hzwjsnkBSP8uCn6P88")
                .header("Accept", "application/json");
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

    public RequestBuilder addFilter (String field, int type, int value) {
        queryUrl += "&filter[" + field + "][gt]=" + value;
        return this;
    }


    private String add (String field, String value){
        return queryUrl += "&" + field + "=" +  value;
    }

    private String add (String field, int value){
        return queryUrl += field + value;
    }

    private String add (String field, double value){
        return queryUrl += field + value;
    }
}
