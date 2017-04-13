package com.stoups.services;

import com.stoups.models.EPType;
import com.stoups.models.Game;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by astouparenko on 4/11/2017.
 */
@Service
public class GameClientService {

    public List<Game> getGamesAboveScore (int minScore) {

        List<Game> gameList = new ArrayList<Game>();

        RequestBuilder builder = new RequestBuilder();
        builder.addLimit(15).sortbyDate().addFields("rating,name");
        GetRequest request = builder.createGetRequest(EPType.GAMES);
        try {
            HttpResponse<JsonNode> response = request.asJson();
            if (response.getBody() != null && response.getBody().isArray()){
                JSONArray arr = response.getBody().getArray();
                for (int i = 0; i < arr.length(); i++){
                    Game game = (Game)arr.get(i);
                    gameList.add(game);
                }

            }
        } catch (UnirestException e) {
            System.out.println("Could not fetch response from API. URL: " + request.getUrl());
        }

        return gameList;
    }

}
