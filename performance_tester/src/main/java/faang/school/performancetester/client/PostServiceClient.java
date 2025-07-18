package faang.school.performancetester.client;

import faang.school.performancetester.dto.PostUiDto;
import faang.school.performancetester.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "post-service", url = "${post-service.host}:${post-service.port}")
public interface PostServiceClient {
    @GetMapping("/api/v1/newsfeed/{userId}/content")
    List<PostUiDto> getNewsFeedContent(@PathVariable Long userId,
                                              @RequestParam(required = false) Long lastPostId);
}
