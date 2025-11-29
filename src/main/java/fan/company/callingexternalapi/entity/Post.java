package fan.company.callingexternalapi.entity;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;

}
