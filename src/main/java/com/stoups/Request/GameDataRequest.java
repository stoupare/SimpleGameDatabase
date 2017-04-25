package com.stoups.Request;

import com.stoups.models.FilterPostFix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 4/14/2017.
 */
public class GameDataRequest {

    private String query;

    private List<String> titles;

    private int offset;

    private int rows;

    //Array maps as [{Field}, {Value}]
    private Map<FilterPostFix, String[]> filterMap;

    private List<String> data;

    private ArrayList<String> genres;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
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
}
