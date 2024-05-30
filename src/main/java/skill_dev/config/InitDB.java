package skill_dev.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import skill_dev.models.request.GradeRequest;
import skill_dev.models.request.SubmitRequest;
import skill_dev.models.request.TaskCreateRequest;
import skill_dev.models.request.UserCreateRequest;
import skill_dev.services.GradeService;
import skill_dev.services.SubmissionService;
import skill_dev.services.TaskService;
import skill_dev.services.UserService;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDB {
    private final TaskService taskService;
    private final UserService userService;
    private final SubmissionService submissionService;
    private final GradeService gradeService;

    @PostConstruct
    public void init(){
        initTasks();
        initUsers();
        initSubmissions();
        initGrades();
    }

    private void initTasks(){

        if (taskService.countTasks() == 0) {
            createTask("Сумма чисел", "Напишите программу, которая принимает 2 числа через пробел, например \"3 4\" и выводит на экран сумму этих чисел.", "", "1 4", "5", 2.0f);
            createTask("Переворот строки", "Напишите программу, которая принимает на вход строку и выводим на экран эту же строку наоборот.", "", "abc", "cba", 2.0f);
        }
    }

    private void initUsers(){
        //createUserRequest("aselya", "12345", "Асель","Джураева", "aseldzhuraeva@gmail.com", "12345");
    }

    private void initSubmissions(){
        //submit(1L, 1L, "2 + 2 = 4");
        //submit(2L, 1L, "Bishkek");
//        submit(1L, 2L, "2 + 2 = 4");
//        submit(2L, 2L, "Osh");
//        submit(1L, 3L, "2 + 2 = 22");
//        submit(2L, 3L, "Toktogul");
    }

    private void initGrades(){
        //estimate(1L, 2F, "Excellent");
        //estimate(2L, 2F, "Good job");
//        estimate(3L, 2F, "Good job");
//        estimate(4L, 0F, "You seem like oshskiy)");
//        estimate(5L, 0F, "Think better");
//        estimate(6L, 0F, "Toktogul is not ozuncho:)");
    }



    //task
    private void createTask(String title, String description, String image, String input, String answer, Float maxPoints) {
        TaskCreateRequest task = new TaskCreateRequest(
                title,
                description,
                image,
                input,
                answer,
                maxPoints
        );
        taskService.createTask(task);
    }

    //user
    private void createUserRequest(String username, String password, String firstName, String lastName, String email, String password2) {
        UserCreateRequest user = new UserCreateRequest(
                username, password, firstName, lastName, email, password2
        );
        userService.register(user);
    }


    //submission
    private void submit(Long taskID, Long userID, String content, Boolean ok){
        SubmitRequest submitRequest = new SubmitRequest(taskID, userID, content, ok);
        submissionService.submit(submitRequest);
    }


    //grade
    private void estimate(Long submissionId, Float score, String feedback){
        GradeRequest request = new GradeRequest(submissionId, score, feedback);
        gradeService.estimate(request);
    }

}
