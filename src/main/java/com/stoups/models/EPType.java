package com.stoups.models;

/**
 * Created by astouparenko on 4/11/2017.
 */
public enum EPType {

    GAMES,
    FRANCHISES,
    COMPANIES,
    REVIEWS,
    PLAFORMS,
    GENRES;

    @Override
    public String toString() {
        return name().toLowerCase() + "/";
    }
}
