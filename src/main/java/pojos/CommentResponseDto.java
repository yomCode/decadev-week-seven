package pojos;

import dev.decagon.fcaebookdemo.models.Post;
import dev.decagon.fcaebookdemo.models.User;
import lombok.Data;

@Data
public class CommentResponseDto {

    private Long id;
    private String content;
    private User user_id;
    private Post post_id;


}
