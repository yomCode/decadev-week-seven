package dev.decagon.fcaebookdemo.controller;

import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pojos.UserDto;

@Controller
@RequestMapping("")
public class UserController {

    UserService userService;

    @GetMapping("/home")
    public String homePage(){
        return "index";
    }



    @GetMapping("/register")
    public String signup(Model model){

    model.addAttribute("user", new UserDto());

    return "signup";

    }

    @PostMapping("/registration_process")
    public String registration_process(UserDto userDto){

       if(userService.getUserbyEmail(userDto.getEmail()) != null) {

            return "welcome";

       }



        return "login";

    }

    @PostMapping()
    public String login(Model model){
        model.addAttribute("user", new User());

        return "  ";

    }

}
