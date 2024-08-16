package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.ListeningOpenEndedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListeningOpenEndedRepository extends JpaRepository<ListeningOpenEndedEntity, Long> {
}
