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
            createTask("Сумма чисел", "Напишите программу, которая принимает 2 числа через пробел, например \"3 4\" и выводит на экран сумму этих чисел.", "", "1 4", "5", 1.0);
            createTask("Переворот строки", "Напишите программу, которая принимает на вход строку и выводим на экран эту же строку наоборот.", "", "abc", "cba", 2.0);

            createTask("Произведение чисел", "Напишите программу, которая принимает 2 числа через пробел и выводит их произведение.", "", "2 5", "10", 1.5);

            createTask("Проверка четности", "Напишите программу, которая принимает одно число и выводит 'четное', если число четное, и 'нечетное', если число нечетное.", "", "7", "нечетное", 2.0);

            createTask("Сумма цифр числа", "Напишите программу, которая принимает на вход одно число и выводит сумму его цифр.", "", "123", "6", 2.5);

            createTask("Факториал числа", "Напишите программу, которая принимает на вход одно число и выводит его факториал.", "", "5", "120", 3.0);

            createTask("Проверка простоты числа", "Напишите программу, которая принимает одно число и выводит 'простое', если число простое, и 'составное', если число составное.", "", "11", "простое", 3.5);

            createTask("Сортировка списка чисел", "Напишите программу, которая принимает на вход список чисел, разделенных пробелами, и выводит их в отсортированном порядке. Пример: если ввести \"1 3 1 2\" то программа выведет \"1 1 2 3\" ", "", "4 2 7 1", "1 2 4 7", 4.0);

            createTask("Фибоначчи", "Напишите программу, которая принимает на вход число n и выводит n-е число Фибоначчи. Пример: если ввести \"6\" то программа выведет \"8\" ", "", "7", "13", 4.5);

            createTask("Калькулятор", "Напишите программу, которая принимает на вход два числа и оператор (+, -, *, /), разделенные пробелами, и выводит результат операции. Пример: если ввести \"1 3 +\" то программа выведет \"4\"", "", "8 4 /", "2", 5.0);

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
    private void createTask(String title, String description, String image, String input, String answer, Double maxPoints) {
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
    private void estimate(Long submissionId, Double score, String feedback){
        GradeRequest request = new GradeRequest(submissionId, score, feedback);
        gradeService.estimate(request);
    }

}
