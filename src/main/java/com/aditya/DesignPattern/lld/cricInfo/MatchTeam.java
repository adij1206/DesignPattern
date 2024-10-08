package com.aditya.DesignPattern.lld.cricInfo;

import lombok.Data;

import java.util.UUID;

@Data
public class MatchTeam {

    private String id;
    private String teamId;
    private String matchId;

    public MatchTeam(String matchId, String teamId) {
        this.id = UUID.randomUUID().toString();
        this.matchId = matchId;
        this.teamId = teamId;
    }
}
