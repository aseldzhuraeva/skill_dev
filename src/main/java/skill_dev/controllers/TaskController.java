package skill_dev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import skill_dev.models.entities.Task;
import skill_dev.python.PythonRunner;
import skill_dev.services.TaskService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @Autowired
    private PythonRunner pythonRunner;

    @PostMapping("/task")
    public String runTask()
    {
        //String result = pythonRunner.executePythonScript("print(1+2)");

        //System.out.println(result);

        String script = "def f(a,b):\n\treturn a+b\n";

        String result = pythonRunner.executePythonFunction(script, "f", 10,20);

        System.out.println(">>" + result.trim() + "<<");

        return "index";
    }

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
