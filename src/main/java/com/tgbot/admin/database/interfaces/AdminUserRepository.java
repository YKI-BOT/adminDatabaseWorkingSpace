package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
    AdminUser findByUsername(String username);
}
