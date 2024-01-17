package com.UserFeedback.repositories;

import org.springframework.data.repository.CrudRepository;
import com.UserFeedback.entities.*;
public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{
}
