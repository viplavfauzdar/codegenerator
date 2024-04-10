package com.viplav.utils.spring.codegenerator.utils;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CallHistoryRepository extends JpaRepository<CallHistory, CallHistoryId> {
    // Add custom queries if needed
}