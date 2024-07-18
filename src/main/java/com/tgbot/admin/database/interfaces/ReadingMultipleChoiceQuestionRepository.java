package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.ReadingMultipleChoiceQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReadingMultipleChoiceQuestionRepository extends JpaRepository<ReadingMultipleChoiceQuestion, Long> {

    @Query("SELECT q FROM ReadingMultipleChoiceQuestion q JOIN FETCH q.answers WHERE q.textId = ?1")
    List<ReadingMultipleChoiceQuestion> findAllWithAnswersByTextId(Long textId);

    @Query(value = "SELECT text_id FROM tasks.reading_multiple_choice_questions ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Long findRandomTextId();
}
