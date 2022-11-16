package dev.decagon.fcaebookdemo.controller;

import dev.decagon.fcaebookdemo.models.Comment;
import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

//    @GetMapping("/comments")
//    public String feedsComment(@RequestParam(value="c, Model model){
////        List<Comment> listOfComments = commentService.getAllComment(post_id);
//        model.addAttribute("commentList", listOfComments);
//
//        return "feeds";
//
//    }

    @PostMapping("/comment")
    public String newComment(@RequestParam(value = "content") String content, @RequestParam(value = "post_id") Long post_id, HttpSession session){
        User user = (User) session.getAttribute("currUser");

        commentService.saveComment(content, user.getId(), post_id);

        return "redirect:/feeds";
    }

//    @PostMapping("/comments")
//    public String getComments(@RequestParam(value = "comments") Long post_id){
//
//
//        return "redirect:/feeds";
//    }



}
