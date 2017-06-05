package com.stoups.controller;

import com.stoups.request.AnalyticsRequest;
import com.stoups.models.Comment;
import com.stoups.services.video.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by astouparenko on 5/1/2017.
 */

@RestController
@RequestMapping(value = {"/core/analytics"})
public class AnalyticsController {
}
