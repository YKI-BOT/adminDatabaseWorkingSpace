package com.tgbot.admin.database.interfaces;


import com.tgbot.admin.database.entity.ListeningMultipleChoiceAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListeningMultipleChoiceAnswerRepository extends JpaRepository<ListeningMultipleChoiceAnswer, Long> {
    @Query("SELECT l FROM ListeningMultipleChoiceAnswer l ORDER BY l.id")
    List<ListeningMultipleChoiceAnswer> findAllOrderById();
}
