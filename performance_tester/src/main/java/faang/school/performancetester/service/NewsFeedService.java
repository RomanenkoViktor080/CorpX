package faang.school.performancetester.service;

import faang.school.performancetester.client.PostServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsFeedService {
    private final PostServiceClient postServiceClient;

    public long getNewsFeedBatch() {
        long startTime = System.currentTimeMillis();
        for(long i=40; i<1040; i++) {
            postServiceClient.getNewsFeedContent(i, null);
        }
        return System.currentTimeMillis()-startTime;
    }
}
