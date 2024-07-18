package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.ReadingTextsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingTextsRepository extends JpaRepository<ReadingTextsEntity, Long> {
}
