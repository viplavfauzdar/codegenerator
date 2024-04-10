package com.viplav.utils.spring.codegenerator.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CallHistoryService {

    private final CallHistoryRepository callHistoryRepository;

    @Autowired
    public CallHistoryService(CallHistoryRepository callHistoryRepository) {
        this.callHistoryRepository = callHistoryRepository;
    }

    public List<CallHistory> getAllCallHistories() {
        return callHistoryRepository.findAll();
    }

    public CallHistory saveCallHistory(CallHistory callHistory) {
        return callHistoryRepository.save(callHistory);
    }

    public List<CallHistory> saveCallHistoryAll(List<CallHistory> callHistoryAll) {
        return callHistoryRepository.saveAll(callHistoryAll);
    }

    public Optional<CallHistory> getCallHistory(CallHistoryId id) {
        return callHistoryRepository.findById(id);
    }

}
