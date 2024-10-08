package com.aditya.DesignPattern.lld.cricInfo;

import java.util.List;

public class CricInfo {

    private static CricInfo instance;
    private PlayerService playerService;
    private TeamService teamService;
    private MatchService matchService;
    private ScoreCardService scoreCardService;


    private CricInfo() {
        this.matchService = new MatchService();
        this.playerService = new PlayerService();
        this.scoreCardService = new ScoreCardService();
        this.teamService = new TeamService();
    }

    public static CricInfo getInstance() {
        if (instance == null) {
            instance = new CricInfo();
        }

        return instance;
    }

    public void addPlayer(Player player) {
        playerService.addPlayer(player);
    }

    public Player getPlayer(String playerId) {
        return playerService.getPlayer(playerId);
    }

    public void addTeam(Team team) {
        teamService.addTeam(team);
    }

    public void addTeamPlayer(List<Player> playerList, String teamId) {
        for (Player player : playerList) {
            TeamPlayer teamPlayer = new TeamPlayer(teamId, player.getId());
            teamService.addTeamPLayer(teamPlayer);
        }
    }

    public List<TeamPlayer> getPlayerList(String teamId) {
        return teamService.getTeamPlayerListById(teamId);
    }

    public Team getTeamById(String id) {
        return teamService.getTeamById(id);
    }

    public void addMatch(Match match) {
        matchService.addMatch(match);
    }

    public Match getMatch9(String matchId) {
        return matchService.getMatchById(matchId);
    }

    public void addTeamsInMatch(String matchId, List<Team> teamList) {
        for (Team team : teamList) {
            MatchTeam matchTeam = new MatchTeam(matchId, team.getId());
            matchService.addMatchTeams(matchTeam);
        }
    }

    public List<MatchTeam> getMatchTeamListByMatchId(String matchId) {
        return matchService.getMatchTeamByMatchId(matchId);
    }

    public void updateStatusOfMatch(String matchId, MatchStatus status) {
        matchService.updateMatchStatus(matchId, status);
    }

    public ScoreCard createScoreCard(String matchId) {
        return scoreCardService.createScoreCard(matchId);
    }

    public void addScore(String teamId, String scoreId, int score) {
        scoreCardService.addScore(teamId, scoreId, score);
    }

    public void addInnings(Innings innings) {
        scoreCardService.addInnings(innings);
    }

    public List<Innings> getInnings(String scoreCardId) {
        return scoreCardService.getInningsListByScoreCardId(scoreCardId);
    }

    public void addOver(Over over) {
        scoreCardService.addOver(over);
    }

    public List<Over> getOverListByInningsId(String inningId) {
        return scoreCardService.getOverListByInningId(inningId);
    }
}
