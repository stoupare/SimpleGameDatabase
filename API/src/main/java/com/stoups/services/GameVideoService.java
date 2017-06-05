package com.stoups.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.stoups.request.GameDataRequest;
import com.stoups.models.enums.EPType;
import com.stoups.models.enums.FilterPostFix;
import com.stoups.models.Game;
import com.stoups.models.Video;
import com.stoups.services.video.service.YoutubeVideoCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by astouparenko on 4/11/2017.
 */
@Service
public class GameVideoService {

    @Autowired
    RequestBuilder builder;

    @Autowired
    YoutubeVideoCollector videoCollector;

    public static int MAX_VIDEOS_PER_GAME = 5;

    public List<Game> getGamesAboveScore (int minScore) throws UnirestException {

        ArrayList<Game> gameList = new ArrayList<Game>();

        //Build the request
        builder.addLimit(15).sortbyDate().addFields("rating,name").addFilter("rating", FilterPostFix.gte, minScore);
        builder.createGetRequest(EPType.GAMES);

        gameList = builder.sendAndParseToList(gameList, Game.class);

        for (Game game : gameList) {
            //Collect Twitch/Youtube Links
            List<Video> videos = videoCollector.searchYoutubeVideos(game.getTitle(), "viewCount", MAX_VIDEOS_PER_GAME);
            game.setVideos(videos);
        }

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
        games = builder.sendAndParseToList(games, Game.class);

        for (Game game : games) {
            //Collect Twitch/Youtube Links
            List<Video> videos = videoCollector.searchYoutubeVideos(game.getTitle(), "viewCount", MAX_VIDEOS_PER_GAME);
            game.setVideos(videos);
        }

        return games;
    }

    public Game findGame(String searchTerm) {

        return null;
    }
}
