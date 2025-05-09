package faang.school.performancetester.service;

import faang.school.performancetester.client.UrlShortenerClient;
import faang.school.performancetester.entity.UrlDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {
    private final UrlShortenerClient urlShortenerClient;

public void loadSetShortUrl(int number) {
    UrlDto urlDto = new UrlDto();
    String time = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    StringBuilder url = new StringBuilder();
    url.append("https://www.test-");
    url.append(time);
    url.append("-");
    int offset = url.length();
    String finalUrl;
    for(Integer i= 0; i < number; i++) {
        url.insert(offset-1, i.toString() + ".com" );
//        urlDto.setUrl(url.toString());
        urlDto.setUrl("https://www.test-2025-05-09-" + i.toString() + ".com");
        urlShortenerClient.setShortUrl(3, urlDto);
    }
}
}
