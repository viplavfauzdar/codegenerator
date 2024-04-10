package com.viplav.utils.spring.codegenerator.utils;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CallHistoryId {

    @Column(name = "SOURCEID")
    @Id
    private BigDecimal sourceid;
    @Id
    @Column(name = "ROWDATE")
    private BigDecimal rowdate;
    @Id
    @Column(name = "SEGMENT")
    private BigDecimal segment;
    @Id
    @Column(name = "CALLID")
    private BigDecimal callid;
}
