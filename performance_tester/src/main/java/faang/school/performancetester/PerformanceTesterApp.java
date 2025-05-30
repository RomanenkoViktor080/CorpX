package faang.school.performancetester;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class PerformanceTesterApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PerformanceTesterApp.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}