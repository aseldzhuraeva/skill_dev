package skill_dev.services;

import skill_dev.models.entities.Submission;
import skill_dev.models.request.SubmitRequest;

import java.util.List;

public interface SubmissionService {
    Submission submit(SubmitRequest request);
    Submission getSubmissionById(Long id);


    Boolean containsCompletedTask(Long id);
}
