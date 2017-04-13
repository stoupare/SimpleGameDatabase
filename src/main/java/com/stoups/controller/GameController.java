package com.stoups.controller;

import com.stoups.services.GameClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by astouparenko on 4/11/2017.
 */

@Controller
@RestController
@RequestMapping(value = {"/core/games"})
public class GameController {

    @Autowired
    GameClientService gameClient;

    @RequestMapping(value = "/top/{minScore}", method = RequestMethod.GET)
    public @ResponseBody void getTopGames(@PathVariable int minScore){

        gameClient.getGamesAboveScore(minScore);
    }


}
