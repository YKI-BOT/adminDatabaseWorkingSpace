package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.WritingEssayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritingEssayRepository extends JpaRepository<WritingEssayEntity, Long> {
}
