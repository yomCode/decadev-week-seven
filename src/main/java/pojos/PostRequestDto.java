package pojos;

import dev.decagon.fcaebookdemo.models.User;
import lombok.Data;

@Data
public class PostDto {

    private String content;
    private User user_id;
}
