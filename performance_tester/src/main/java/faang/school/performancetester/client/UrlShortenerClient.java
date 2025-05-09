package faang.school.performancetester.client;

import faang.school.performancetester.entity.UrlDto;
import faang.school.performancetester.entity.RedisUrl;
import feign.Headers;
import feign.Request;
import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "url-shortener-service", url = "${url-shortener-service.host}:${url-shortener-service.port}")
public interface UrlShortenerClient {
    @PostMapping("/api/v1/url")
    RedisUrl setShortUrl(
            @RequestHeader("x-user-id") int userId,
            @Validated @RequestBody UrlDto urlDto
    );
}
