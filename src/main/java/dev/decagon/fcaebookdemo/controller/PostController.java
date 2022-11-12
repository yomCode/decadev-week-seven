package dev.decagon.fcaebookdemo.controller;

import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pojos.PostRequestDto;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/new_post")
    public String createNewPost(@ModelAttribute PostRequestDto postRequestDto, Model model, HttpSession session){

        model.addAttribute("post", postRequestDto);
        User user = (User) session.getAttribute("currUser");

        postService.createNewPost(postRequestDto, user.getId());

        return "feeds";
    }


}
