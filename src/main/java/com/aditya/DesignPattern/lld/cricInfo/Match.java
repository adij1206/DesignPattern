package com.aditya.DesignPattern.lld.cricInfo;

import lombok.Data;

import java.util.UUID;

@Data
public class Match {

    private String matchId;
    private String venue;
    private String status;
    private Long startTime;
    private String scoreCardId;

    public Match(String venue, Long startTime) {
        this.matchId = UUID.randomUUID().toString();
        this.venue = venue;
        this.startTime = startTime;
        this.status = MatchStatus.SCHEDULED.toString();
    }
}
