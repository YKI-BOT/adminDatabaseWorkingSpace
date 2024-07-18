package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.ReadingOpenEndedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingOpenEndedRepository extends JpaRepository<ReadingOpenEndedEntity, Long> {
    List<ReadingOpenEndedEntity> findByTextId(Long textId);

    @Query(value = "SELECT * FROM tasks.reading_open_ended WHERE text_id = (SELECT text_id ORDER BY random()) ORDER BY id", nativeQuery = true)
    List<ReadingOpenEndedEntity> findByRandomTextId();
}
