package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.BotUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotUsersRepository extends JpaRepository<BotUsersEntity, Long> {
    BotUsersEntity findByChatId(Long chatId);
}
