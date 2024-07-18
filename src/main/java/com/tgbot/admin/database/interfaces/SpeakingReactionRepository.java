package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.SpeakingReactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakingReactionRepository extends JpaRepository<SpeakingReactionEntity, Long> {
}
