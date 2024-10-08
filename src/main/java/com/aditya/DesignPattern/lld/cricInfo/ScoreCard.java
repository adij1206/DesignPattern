package com.aditya.DesignPattern.lld.cricInfo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class ScoreCard {

    private String id;
    private String matchId;
    private Map<String, Integer> teamScores;

    public ScoreCard(String matchId) {
        this.id = UUID.randomUUID().toString();
        this.matchId = matchId;
        this.teamScores = new HashMap<>();
    }

    public void addScore(String teamId, Integer score) {
        Integer orDefault = teamScores.getOrDefault(teamId, 0);
        orDefault += score;

        teamScores.put(teamId, orDefault);
    }
}
