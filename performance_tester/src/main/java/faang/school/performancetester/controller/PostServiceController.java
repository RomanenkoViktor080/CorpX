package faang.school.performancetester.controller;

import faang.school.performancetester.service.NewsFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/performance/postservice")
public class PostServiceController {

    private final NewsFeedService newsFeedService;

    @PostMapping("/newsfeed/batch")
    @ResponseBody
    public long getNewsFeedBatch() {
        return  newsFeedService.getNewsFeedBatch();
    }
}
