package com.aditya.DesignPattern.lld.cricInfo;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        //
        Player player1 = new Player("Aditya", "batsman");
        Player player2 = new Player("aadi", "bowler");
        Player player3 = new Player("Paras", "batsman");
        Player player4 = new Player("Manish", "bowler");

        CricInfo info = CricInfo.getInstance();

        info.addPlayer(player1);
        info.addPlayer(player2);
        info.addPlayer(player3);
        info.addPlayer(player4);

        Team team1 = new Team("Abc");
        Team team2 = new Team("Bcd");

        info.addTeam(team1);
        info.addTeamPlayer(Arrays.asList(player1, player2), team1.getId());

        info.addTeam(team2);
        info.addTeamPlayer(Arrays.asList(player1, player2), team2.getId());

        Match match = new Match("India", System.currentTimeMillis()+5000);
        info.addMatch(match);

        info.addTeamsInMatch(match.getMatchId(), Arrays.asList(team1, team2));

        ScoreCard scoreCard = info.createScoreCard(match.getMatchId());

        Innings innings1 = new Innings(scoreCard.getId(), team1.getId(), team2.getId());
        info.addInnings(innings1);

        Over over = new Over("1", innings1.getId());
        info.addOver(over);

        Innings innings2 = new Innings(scoreCard.getId(), team2.getId(), team1.getId());
        info.addInnings(innings2);

        Over over2 = new Over("1", innings2.getId());
        info.addOver(over2);

        info.addScore(team1.getId(), scoreCard.getId(), 4);
        info.addScore(team1.getId(), scoreCard.getId(), 4);

        info.addScore(team2.getId(), scoreCard.getId(), 2);
        info.addScore(team2.getId(), scoreCard.getId(), 4);

        System.out.println(info.getMatch9(match.getMatchId()));
        System.out.println(info.getMatchTeamListByMatchId(match.getMatchId()));
        System.out.println(info.getPlayer(player1.getId()));
        System.out.println(info.getTeamById(team1.getId()));
        System.out.println(info.getInnings(scoreCard.getId()));
        System.out.println(info.getOverListByInningsId(innings1.getId()));

        info.updateStatusOfMatch(match.getMatchId(), MatchStatus.COMPLETED);
        System.out.println(info.getMatch9(match.getMatchId()));
    }
}
