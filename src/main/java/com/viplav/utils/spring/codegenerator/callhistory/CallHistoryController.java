package com.viplav.utils.spring.codegenerator.callhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/callhistory")
@Slf4j
public class CallHistoryController {

    private final CallHistoryService callHistoryService;

    @Autowired
    public CallHistoryController(CallHistoryService callHistoryService) {
        this.callHistoryService = callHistoryService;
    }

    @CrossOrigin
    @GetMapping("/findall")
    public List<CallHistory> getAllCallHistories() {
        return callHistoryService.getAllCallHistories();
    }

    @PostMapping(value = "/save")
    public CallHistory saveCallHistory(@RequestBody CallHistory callHistory) {
        log.info("Call History: {}",callHistory);
        return callHistoryService.saveCallHistory(callHistory);
    }

    @PostMapping(value = "/saveall")
    public List<CallHistory> saveCallHistoryAll(@RequestBody List<CallHistory> callHistoryAll) {
        log.info("Call History: {}",callHistoryAll);
        return callHistoryService.saveCallHistoryAll(callHistoryAll);
    }

    @PostMapping("/findone")
    public Optional<CallHistory> getCallHistory(@RequestBody CallHistoryId id) {
        return callHistoryService.getCallHistory(id);
    }
}