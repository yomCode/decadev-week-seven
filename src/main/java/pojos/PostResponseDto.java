package pojos;

import dev.decagon.fcaebookdemo.models.User;
import lombok.Data;

@Data
public class PostResponseDto {

    private Long id;
    private String post_content;
    private User user_id;


}
