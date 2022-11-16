package dev.decagon.fcaebookdemo.controller;

import dev.decagon.fcaebookdemo.models.Comment;
import dev.decagon.fcaebookdemo.models.Post;
import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojos.PostRequestDto;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/feeds")
    public String welcome_page(Model model){
        List<Post> listOfPost = postService.getAllPost();
        model.addAttribute("postList", listOfPost);

        return "feeds";
    }

    @PostMapping("/new_post")
    public String createNewPost(@ModelAttribute PostRequestDto postRequestDto, Model model, HttpSession session){

        model.addAttribute("post", postRequestDto);
        User user = (User) session.getAttribute("currUser");

        postService.createNewPost(postRequestDto, user.getId());

        return "redirect:/feeds";
    }

    @PostMapping("/deletePost")
    public String deletePost(@RequestParam(value = "post_id") Long post_id, Model model){
        model.addAttribute("post_id", post_id);

        postService.deletePost(post_id);

        return "redirect:/feeds";
    }


}
