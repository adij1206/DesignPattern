package com.aditya.DesignPattern.lld.cricInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchService {

    private Map<String, Match> matchMap;
    private Map<String, MatchTeam> matchTeamMap;

    public MatchService() {
        this.matchMap = new HashMap<>();
        this.matchTeamMap = new HashMap<>();
    }

    public void addMatch(Match match) {
        matchMap.put(match.getMatchId(), match);
    }

    public Match getMatchById(String matchId) {
        return matchMap.get(matchId);
    }

    public void addMatchTeams(MatchTeam matchTeam) {
        matchTeamMap.put(matchTeam.getId(), matchTeam);
    }

    public List<MatchTeam> getMatchTeamByMatchId(String matchId) {
        List<MatchTeam> teams = new ArrayList<>();
        for (MatchTeam matchTeam : matchTeamMap.values()) {
            if (matchTeam.getMatchId().equals(matchId)) {
                teams.add(matchTeam);
            }
        }

        return teams;
    }

    public void updateMatchStatus(String matchId, MatchStatus status) {
        Match match = matchMap.get(matchId);
        match.setStatus(status.name());

        matchMap.put(match.getMatchId(), match);
    }

}
