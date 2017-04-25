package com.stoups.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.stoups.Request.GameDataRequest;
import com.stoups.models.Game;
import com.stoups.services.GameClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by astouparenko on 4/11/2017.
 */

@Controller
@RestController
@RequestMapping(value = {"/core/games"})
public class GameController {

    @Autowired
    GameClientService gameClient;


    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public @ResponseBody
    Game getTopGames(@RequestBody GameDataRequest gameDataRequest) throws UnirestException {

        return gameClient.findGame(gameDataRequest.getQuery());
    }

    @RequestMapping(value = "/top/{minScore}", method = RequestMethod.GET)
    public @ResponseBody
    List<Game> getTopGames(@PathVariable int minScore) throws UnirestException {

        return gameClient.getGamesAboveScore(minScore);
    }

    @RequestMapping(value = "/fetch", method = RequestMethod.POST)
    public @ResponseBody
    List<Game> getGames(@RequestBody GameDataRequest gameDataRequest) throws UnirestException {

        List<Game> games = gameClient.fetchSpecificGames(gameDataRequest);
        return games;
    }

}
