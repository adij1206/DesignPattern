package com.aditya.DesignPattern.lld.cricInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerService {

    Map<String, Player> playerMap;

    public PlayerService() {
        this.playerMap =new HashMap<>();
    }

    public void addPlayer(Player player) {
        this.playerMap.put(player.getId(), player);
    }

    public Player getPlayer(String playerId) {
        return this.playerMap.get(playerId);
    }

    public List<Player> getPlayerByName(String name) {
        List<Player> players = new ArrayList<>();

        for (Player player : playerMap.values()) {
            if (player.getName().contains(name.toLowerCase())) {
                players.add(player);
            }
        }

        return players;
    }
}
