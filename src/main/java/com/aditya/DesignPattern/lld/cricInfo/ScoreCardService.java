package com.aditya.DesignPattern.lld.cricInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreCardService {

    private Map<String, ScoreCard> scoreCardMap;
    private Map<String, Innings> inningsMap;
    private Map<String, Over> overMap;

    public ScoreCardService() {
        this.scoreCardMap = new HashMap<>();
        this.inningsMap = new HashMap<>();
        this.overMap = new HashMap<>();
    }

    public ScoreCard createScoreCard(String matchId) {
        ScoreCard scoreCard = new ScoreCard(matchId);
        scoreCardMap.put(scoreCard.getId(), scoreCard);

        return scoreCard;
    }

    public ScoreCard getScoreCardByMatchId(String matchId) {
        for (ScoreCard scoreCard : scoreCardMap.values()) {
            if (scoreCard.getMatchId().equals(matchId)) {
                return scoreCard;
            }
        }

        return null;
    }

    public void addInnings(Innings innings) {
        inningsMap.put(innings.getId(), innings);
    }

    public List<Innings> getInningsListByScoreCardId(String scoreCardId) {
        List<Innings> inningsList = new ArrayList<>();

        for (Innings innings : inningsMap.values()) {
            if (innings.getScoreCardId().equals(scoreCardId)) {
                inningsList.add(innings);
            }
        }

        return inningsList;
    }

    public void addOver(Over over) {
        overMap.put(over.getId(), over);
    }

    public List<Over> getOverListByInningId(String inningId) {
        List<Over> overs = new ArrayList<>();

        for (Over over : overMap.values()) {
            if (over.getInningId().equals(inningId)) {
                overs.add(over);
            }
        }

        return overs;
    }

    public void addScore(String teamId, String scoreCatrdId, int score) {
        ScoreCard scoreCard = scoreCardMap.get(scoreCatrdId);
        scoreCard.addScore(teamId, score);
    }
}
