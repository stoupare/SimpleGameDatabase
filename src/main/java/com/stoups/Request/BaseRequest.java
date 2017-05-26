package com.stoups.Request;

/**
 * Created by astouparenko on 5/1/2017.
 */
public class BaseRequest {

    private String query;
    private int offset;
    private int rows;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
}
