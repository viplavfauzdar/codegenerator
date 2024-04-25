package com.viplav.utils.spring.codegenerator.callhistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CallHistoryRepository extends JpaRepository<CallHistory, CallHistoryId> {
    // Add custom queries if needed
}