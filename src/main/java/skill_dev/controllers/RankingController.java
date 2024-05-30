package skill_dev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import skill_dev.models.entities.User;
import skill_dev.services.RankingService;

@Controller
@RequiredArgsConstructor
public class RankingController {
    private final RankingService rankingService;

    @GetMapping("/rating")
    public String getRankingPage(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("rankingList", rankingService.getRankings());
        if (user == null)
        {
            model.addAttribute("loggedIn", false);
        }
        else {
            model.addAttribute("loggedIn", true);
        }
        return "rating";
    }
}
