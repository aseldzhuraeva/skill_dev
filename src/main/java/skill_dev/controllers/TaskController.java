package skill_dev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import skill_dev.models.entities.Task;
import skill_dev.models.entities.User;
import skill_dev.models.request.SubmitRequest;
import skill_dev.python.PythonRunner;
import skill_dev.services.SubmissionService;
import skill_dev.services.TaskService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @Autowired
    private PythonRunner pythonRunner;

    private final SubmissionService submissionService;

    @PostMapping("/task/{id}")
    public String runTask(@PathVariable Long id, @AuthenticationPrincipal User user, @RequestParam("validationTextarea") String validationTextarea, Model model)
    {
        if (user == null)
        {
            return "redirect:/login";
        }

        Task task = taskService.getTaskById(id);

        System.out.println(validationTextarea);

        String result = pythonRunner.executePythonScript(validationTextarea, task.getInput());


        System.out.println("Result:");
        System.out.println(result);
        result = result.trim();

        boolean ok = result.equals(task.getAnswer());

        SubmitRequest submitRequest = new SubmitRequest(task.getId(), user.getId(), result, ok);
        submissionService.submit(submitRequest);

        model.addAttribute("task", task);
        model.addAttribute("submitRequest", submitRequest);
        if (ok)
        {
            return "true_check_answer";
        }
        else {
            return "false_check_answer";
        }
    }

    @GetMapping("/")
    public String getHomePage(Model model){
        List<Task> tasks = taskService.getAllTasks();
        System.out.println(tasks.size());
        model.addAttribute("tasks", tasks);
        return "home";
    }

    @GetMapping("/tasks")
    public String getTasksPage(Model model, @AuthenticationPrincipal User user){
        if (user == null)
        {
            return "redirect:/login";
        }
        List<Task> tasks = taskService.getAllTasks();
        System.out.println(tasks.size());
        model.addAttribute("tasks", tasks);
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/task/{id}")
    public String getTaskById(@PathVariable Long id, @AuthenticationPrincipal User user, Model model){
        if (user == null)
        {
            return "redirect:/login";
        }
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task";
    }
}
