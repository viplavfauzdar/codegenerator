package com.viplav.utils.spring.codegenerator.utils;

import java.math.BigDecimal;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@IdClass(CallHistoryId.class)
@Table(name="CallHistory")
@Data
@Entity
public class CallHistory {

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

    @Column(name = "DISPPRIORITY")
    private BigDecimal disppriority;
    @Column(name = "DIALED_NUM")
    private String dialedNum;
    @Column(name = "LASTCWC")
    private String lastcwc;
    @Column(name = "DISPSKLEVEL")
    private BigDecimal dispsklevel;
    @Column(name = "EQLOC")
    private String eqloc;
    @Column(name = "FIRSTIVECTOR")
    private BigDecimal firstivector;
    @Column(name = "ANSLOGIN")
    private String anslogin;
    @Column(name = "RINGTIME")
    private BigDecimal ringtime;
    @Column(name = "AUDIO")
    private BigDecimal audio;
    @Column(name = "UCID")
    private String ucid;
    @Column(name = "DISPOSITION")
    private BigDecimal disposition;
    @Column(name = "DISPVDN")
    private String dispvdn;
    @Column(name = "FIRSTVDN")
    private String firstvdn;
    @Column(name = "OBSERVINGCALL")
    private BigDecimal observingcall;
    @Column(name = "LASTOBSERVER")
    private String lastobserver;
    @Column(name = "INTERRUPTDEL")
    private BigDecimal interruptdel;
    @Column(name = "HELD")
    private BigDecimal held;
    @Column(name = "EQLOCID")
    private BigDecimal eqlocid;
    @Column(name = "OBSLOCID")
    private BigDecimal obslocid;
    @Column(name = "LASTDIGITS")
    private String lastdigits;
    @Column(name = "DA_QUEUED")
    private BigDecimal daQueued;
    @Column(name = "TALKTIME")
    private BigDecimal talktime;
    @Column(name = "PREFSKILLLEVEL")
    private BigDecimal prefskilllevel;
    @Column(name = "TKGRP")
    private BigDecimal tkgrp;
    @Column(name = "AGENTSURPLUS")
    private BigDecimal agentsurplus;
    @Column(name = "NETINTIME")
    private BigDecimal netintime;
    @Column(name = "CALLING_PTY")
    private String callingPty;
    @Column(name = "ORIGHOLDTIME")
    private BigDecimal origholdtime;
    @Column(name = "ORIGREASON")
    private BigDecimal origreason;
    @Column(name = "AGT_RELEASED")
    private BigDecimal agtReleased;
    @Column(name = "TRANSFERRED")
    private BigDecimal transferred;
    @Column(name = "ASAIUUI")
    private String asaiuui;
    @Column(name = "SEGSTOP")
    private String segstop;
    @Column(name = "QUEUETIME")
    private BigDecimal queuetime;
    @Column(name = "DISPTIME")
    private BigDecimal disptime;
    @Column(name = "ORIGLOGIN")
    private String origlogin;
    @Column(name = "ANSHOLDTIME")
    private BigDecimal ansholdtime;
    @Column(name = "ASSIST")
    private BigDecimal assist;
    @Column(name = "CONSULTTIME")
    private BigDecimal consulttime;
    @Column(name = "CALLING_II")
    private String callingIi;
    @Column(name = "SPLIT3")
    private BigDecimal split3;
    @Column(name = "CONFERENCE")
    private BigDecimal conference;
    @Column(name = "SPLIT2")
    private BigDecimal split2;
    @Column(name = "AGENTSKILLLEVEL")
    private BigDecimal agentskilllevel;
    @Column(name = "CWC5")
    private String cwc5;
    @Column(name = "CWC4")
    private String cwc4;
    @Column(name = "SPLIT1")
    private BigDecimal split1;
    @Column(name = "CWC3")
    private String cwc3;
    @Column(name = "DISPSPLIT")
    private BigDecimal dispsplit;
    @Column(name = "CWC2")
    private String cwc2;
    @Column(name = "SEGSTART")
    private String segstart;
    @Column(name = "CWC1")
    private String cwc1;
    @Column(name = "EVENT4")
    private BigDecimal event4;
    @Column(name = "EVENT5")
    private BigDecimal event5;
    @Column(name = "EVENT2")
    private BigDecimal event2;
    @Column(name = "EVENT3")
    private BigDecimal event3;
    @Column(name = "EVENT8")
    private BigDecimal event8;
    @Column(name = "EVENT9")
    private BigDecimal event9;
    @Column(name = "EVENT6")
    private BigDecimal event6;
    @Column(name = "EVENT7")
    private BigDecimal event7;
    @Column(name = "MALICIOUS")
    private BigDecimal malicious;
    @Column(name = "EVENT1")
    private BigDecimal event1;
    @Column(name = "HOLDABN")
    private BigDecimal holdabn;
    @Column(name = "VDN8")
    private String vdn8;
    @Column(name = "UUILEN")
    private BigDecimal uuilen;
    @Column(name = "VDN9")
    private String vdn9;
    @Column(name = "ANSREASON")
    private BigDecimal ansreason;
    @Column(name = "DISPIVECTOR")
    private BigDecimal dispivector;
    @Column(name = "ACWTIME")
    private BigDecimal acwtime;
    @Column(name = "VDN2")
    private String vdn2;
    @Column(name = "ORIGLOCID")
    private BigDecimal origlocid;
    @Column(name = "VDN3")
    private String vdn3;
    @Column(name = "VDN4")
    private String vdn4;
    @Column(name = "ANSLOCID")
    private BigDecimal anslocid;
    @Column(name = "VDN5")
    private String vdn5;
    @Column(name = "DURATION")
    private BigDecimal duration;
    @Column(name = "VDN6")
    private String vdn6;
    @Column(name = "VDN7")
    private String vdn7;
}