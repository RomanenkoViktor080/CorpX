package faang.school.performancetester.controller;

import faang.school.performancetester.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/performance/userservice")
public class UserServiceController {
    private final UserService userService;

    @PostMapping("/add/followers")
    public void addFollowers() {
        userService.addFollowers();
    }
}
