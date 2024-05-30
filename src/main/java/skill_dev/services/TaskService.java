package skill_dev.services;

import skill_dev.models.entities.Task;
import skill_dev.models.request.TaskCreateRequest;

import java.util.List;

public interface TaskService {
    void createTask(TaskCreateRequest request);

    List<Task> getAllTasks();
    Task getTaskById(Long id);

    long countTasks();

}
