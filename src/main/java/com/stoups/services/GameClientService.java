package com.stoups.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.stoups.Request.GameDataRequest;
import com.stoups.models.EPType;
import com.stoups.models.FilterPostFix;
import com.stoups.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by astouparenko on 4/11/2017.
 */
@Service
public class GameClientService {

    @Autowired
    RequestBuilder builder;


    public List<Game> getGamesAboveScore (int minScore) throws UnirestException {

        ArrayList<Game> gameList = new ArrayList<Game>();

        //Build the request
        builder.addLimit(15).sortbyDate().addFields("rating,name").addFilter("rating", FilterPostFix.gte, minScore);
        builder.createGetRequest(EPType.GAMES);

        gameList = builder.sendAndParseToList(gameList, Game.class);

        return gameList;
    }

    public ArrayList<Game> fetchSpecificGames(GameDataRequest gameRequest) throws UnirestException {
        int rows = gameRequest.getRows();
        int offset = gameRequest.getOffset();
        String q = gameRequest.getQuery();
        ArrayList<String> genres = gameRequest.getGenres();
        Map<FilterPostFix, String[]> filters = gameRequest.getFilterMap();

        ArrayList<Game> games = new ArrayList<Game>();

        builder.addLimit(rows).addOffset(offset).addSearch(q).
                addData(gameRequest.getData()).addFiltersMap(filters).sortbyDate();

        builder.createGetRequest(EPType.GAMES);
        return builder.sendAndParseToList(games, Game.class);
    }

    public Game findGame(String searchTerm) {

        return null;
    }
}
