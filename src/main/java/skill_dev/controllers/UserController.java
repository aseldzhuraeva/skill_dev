package skill_dev.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import skill_dev.models.request.UserCreateRequest;
import skill_dev.services.UserService;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String getSignInPage(){
        return "log_in";
    }

    @GetMapping("/sign-up")
    public String getSignUpPage(){
        return "register";
    }

    @PostMapping(value = "/sign-up")
    public String createUser(@ModelAttribute("user") UserCreateRequest form, Model model, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("error", bindingResult.getGlobalError().getDefaultMessage());
//            return "register";
//        }
        if (bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getGlobalError().getDefaultMessage());
            return "register";
        }
        if (!form.getPassword().equals(form.getPassword2())){
            model.addAttribute("error", "password mismatch");
            return "register";
        }
        userService.register(form);
        return "redirect:/login";
    }

}
