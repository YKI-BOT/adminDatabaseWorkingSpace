package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "bot_users", schema = "users")
@Data
public class BotUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bot_users")
    private Long id;

    @Column(name = "telegram_username")
    private String username;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "subscription_time")
    private LocalDate subscriptionTime;

    @Column(name = "is_subscribed")
    private boolean isSubscribed;
}
