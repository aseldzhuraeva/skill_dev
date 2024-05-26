package skill_dev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import skill_dev.models.entities.Task;
import skill_dev.services.TaskService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/")
    public String getHomePage(Model model){
        List<Task> tasks = taskService.getAllTasks();
        System.out.println(tasks.size());
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/task/{id}")
    public String getTaskById(@PathVariable Long id, Model model){
        try{
            Task task = taskService.getTaskById(id);
            model.addAttribute("title", task.getTitle());
            model.addAttribute("description", task.getDescription());
            model.addAttribute("maxPoints", task.getMaxPoints());
            return "zadanie";
        }
        catch (IllegalArgumentException e){
            return "index";
        }
    }
}
