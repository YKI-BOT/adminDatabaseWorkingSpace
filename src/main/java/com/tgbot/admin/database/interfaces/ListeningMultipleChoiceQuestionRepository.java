package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.ListeningMultipleChoiceQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListeningMultipleChoiceQuestionRepository extends JpaRepository<ListeningMultipleChoiceQuestion, Long> {
}
