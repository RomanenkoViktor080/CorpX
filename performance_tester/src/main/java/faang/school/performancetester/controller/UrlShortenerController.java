package faang.school.performancetester.controller;

import faang.school.performancetester.client.UrlShortenerClient;
import faang.school.performancetester.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/urlshortener")
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    @PostMapping("/set/{number}")
    public void loadSetShortUrl(@PathVariable int number) {
        if(number > 0) {
            urlShortenerService.loadSetShortUrl(number);
        }

    }
}
