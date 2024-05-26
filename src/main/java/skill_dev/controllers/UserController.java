package skill_dev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/sign-in")
    public String getSignInPage(){
        return "log_in";
    }

    @GetMapping("/sign-up")
    public String getSignUpPage(){
        return "register";
    }
}
