package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.SpeakingDialogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakingDialogRepository extends JpaRepository<SpeakingDialogEntity, Long> {
}
