package pojos;


import dev.decagon.fcaebookdemo.models.Post;
import dev.decagon.fcaebookdemo.models.User;
import lombok.Data;

@Data
public class CommentRequestDto {

    private String content;
    private User user_id;
    private Post post_id;

}
