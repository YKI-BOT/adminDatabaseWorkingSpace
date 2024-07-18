package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.ListeningTFEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListeningTFRepository extends JpaRepository<ListeningTFEntity, Long> {
    @Query(value = "SELECT audio_id FROM tasks.listening_true_false ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Long findRandomAudioId();

    @Query(value = "SELECT question, answer FROM tasks.listening_true_false WHERE audio_id = ?1 ORDER BY id", nativeQuery = true)
    List<Object[]> findQuestionsAndAnswersByAudioId(Long textId);
}
