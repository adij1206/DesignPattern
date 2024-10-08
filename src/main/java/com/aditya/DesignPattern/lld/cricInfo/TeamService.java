package com.aditya.DesignPattern.lld.cricInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamService {

    private Map<String, Team> teamMap;
    private Map<String, TeamPlayer> playerMap;

    public TeamService() {
        this.teamMap = new HashMap<>();
        this.playerMap = new HashMap<>();
    }

    public void addTeam(Team team) {
        this.teamMap.put(team.getId(), team);
    }

    public Team getTeamById(String teamId) {
        return teamMap.get(teamId);
    }

    public void addTeamPLayer(TeamPlayer player) {
        this.playerMap.put(player.getId(), player);
    }

    public List<TeamPlayer> getTeamPlayerListById(String teamId) {
        List<TeamPlayer> players = new ArrayList<>();

        for (TeamPlayer teamPlayer : playerMap.values()) {
            if (teamPlayer.getTeamId().equals(teamId)) {
                players.add(teamPlayer);
            }
        }

        return players;
    }
}
