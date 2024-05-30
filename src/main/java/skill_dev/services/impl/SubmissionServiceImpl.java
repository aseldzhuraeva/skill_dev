package skill_dev.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skill_dev.models.entities.Submission;
import skill_dev.models.entities.Task;
import skill_dev.models.entities.User;
import skill_dev.models.request.SubmitRequest;
import skill_dev.repositories.SubmissionRepository;
import skill_dev.services.SubmissionService;
import skill_dev.services.TaskService;
import skill_dev.services.UserService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {
    private final SubmissionRepository submissionRepository;
    private final UserService userService;
    private final TaskService taskService;

    @Transactional
    @Override
    public Submission submit(SubmitRequest request) {
        User user = userService.getUserById(request.getUserId());
        Task task = taskService.getTaskById(request.getTaskId());
        Submission submission = Submission.builder()
                .content(request.getContent())
                .submissionDate(LocalDateTime.now())
                .task(task)
                .user(user)
                .ok(request.getOk())
                .build();

        submissionRepository.save(submission);
        return submission;
    }

    @Override
    public Submission getSubmissionById(Long id) {
        return submissionRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("there is no such submission"));
    }


    @Override
    public Boolean containsCompletedTask(Long id)
    {
        return submissionRepository.existsByTaskIdAndOk(id, true);
    }
}
