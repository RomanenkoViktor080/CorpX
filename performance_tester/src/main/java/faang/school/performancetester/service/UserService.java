package faang.school.performancetester.service;

import faang.school.performancetester.client.UserServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserServiceClient userServiceClient;

    public void addFollowers() {
        List<Long> followees = List.of(1L,2L,3L,4L,5L);
        long followeeId;

        for(long i=44; i<1030; i++) {
            followeeId = followees.get((int)(Math.random()*followees.size()));
            userServiceClient.follow(i, followeeId);
            log.info("follower {} subscribed to followee {}", i, followeeId);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
