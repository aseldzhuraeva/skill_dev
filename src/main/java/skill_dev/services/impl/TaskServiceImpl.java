package skill_dev.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import skill_dev.models.entities.Task;
import skill_dev.models.request.TaskCreateRequest;
import skill_dev.repositories.TaskRepository;
import skill_dev.services.TaskService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Transactional
    @Override
    public void createTask(TaskCreateRequest request) {
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .image(request.getImage())
                .input(request.getInput())
                .answer(request.getAnswer())
                .max_points(request.getMax_points())
                .build();
        taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("there is no such task"));
    }
}
