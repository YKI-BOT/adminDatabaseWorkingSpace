package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.ReadingMultipleChoiceAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingMultipleChoiceAnswerRepository extends JpaRepository<ReadingMultipleChoiceAnswer, Long> {
}
