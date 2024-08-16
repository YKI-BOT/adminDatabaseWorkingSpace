package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.WritingFriendsLetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritingFriendsLetterRepository extends JpaRepository<WritingFriendsLetterEntity, Long> {
}
