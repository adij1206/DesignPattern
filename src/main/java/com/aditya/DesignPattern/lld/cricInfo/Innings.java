package com.aditya.DesignPattern.lld.cricInfo;

import lombok.Data;

import java.util.UUID;

@Data
public class Innings {

    private String id;
    private String scoreCardId;
    private String bowlingTeamId;
    private String battingTeamId;

    public Innings(String scoreCardId, String bowlingTeamId, String battingTeamId) {
        this.id = UUID.randomUUID().toString();
        this.scoreCardId = scoreCardId;
        this.bowlingTeamId = bowlingTeamId;
        this.battingTeamId = battingTeamId;
    }
}
