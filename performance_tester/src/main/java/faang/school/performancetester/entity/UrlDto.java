package faang.school.performancetester.entity;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UrlDto {
    @Pattern(regexp= "^((http|https):/)[-a-zA-Z0-9@:%._+~#?&/=]*",
            message = "\"Некорректный URL\"")
    private String url;
}
