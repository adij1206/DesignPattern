package com.aditya.DesignPattern.lld.cricInfo;

import lombok.Data;

import java.util.UUID;

@Data
public class TeamPlayer {

    private String id;
    private String teamId;
    private String playerId;

    public TeamPlayer(String teamId, String playerId) {
        this.id = UUID.randomUUID().toString();
        this.teamId = teamId;
        this.playerId = playerId;
    }
}
