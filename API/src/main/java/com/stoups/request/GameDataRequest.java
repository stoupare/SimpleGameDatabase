package com.stoups.request;

import com.stoups.models.enums.FilterPostFix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 4/14/2017.
 */
public class GameDataRequest extends BaseRequest {

    private String query;

    private List<String> titles;

    //Array maps as [{Field}, {Value}]
    private Map<FilterPostFix, String[]> filterMap;

    private List<String> data;

    private ArrayList<String> genres;

    private Boolean includeLinks;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public Map<FilterPostFix, String[]> getFilterMap() {
        return filterMap;
    }

    public void setFilterMap(Map<FilterPostFix, String[]> filterMap) {
        this.filterMap = filterMap;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        genres = genres;
    }

    public String getQuery() {
        return (query != null) ? query : "*";
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Boolean getIncludeLinks() {
        return includeLinks;
    }

    public void setIncludeLinks(Boolean includeLinks) {
        this.includeLinks = includeLinks;
    }
}
