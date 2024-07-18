package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.ReadingTFEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingTFRepository extends JpaRepository<ReadingTFEntity, Long> {
}