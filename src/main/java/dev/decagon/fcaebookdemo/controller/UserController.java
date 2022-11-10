package dev.decagon.fcaebookdemo.controller;


import dev.decagon.fcaebookdemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pojos.LoginDto;
import pojos.UserDto;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String getRegistration(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);

        return "signup";

    }

    @GetMapping("/login")
    public String login(Model model){
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginUser", loginDto);

        return "login";
    }

    @GetMapping("/welcome")
    public String welcome_page(){
        return "welcome";
    }

    @PostMapping("/registration_process")
    public String createUser(UserDto userDto){

        userService.saveUserto_Db(userDto);

        return "login";

    }

    @PostMapping("/user-login")
    public String userLogin(UserDto userDto){
        if(userService.validateUser(userDto) != null){
            return "redirect:/welcome";

        }else{
            return "redirect:/login";
        }


    }

}
