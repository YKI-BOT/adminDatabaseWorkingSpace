package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.WritingOfficialLetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WritingOfficialLetterRepository extends JpaRepository<WritingOfficialLetterEntity, Long> {
}
