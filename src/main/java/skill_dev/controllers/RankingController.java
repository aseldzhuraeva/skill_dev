package skill_dev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import skill_dev.services.RankingService;

@Controller
@RequiredArgsConstructor
public class RankingController {
    private final RankingService rankingService;

    @GetMapping("/ranking-list")
    public String getRankingPage(Model model){
        model.addAttribute("rankingList", rankingService.getRankingList());
        return "rating";
    }
}
