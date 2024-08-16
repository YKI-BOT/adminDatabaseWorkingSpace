package com.tgbot.admin.database.interfaces;

import com.tgbot.admin.database.entity.SpeakingMonologueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpeakingMonologueRepository extends JpaRepository<SpeakingMonologueEntity, Long> {
}
