package com.aditya.DesignPattern.lld.snakeAndLadder;

public class Player {

    private String name;
    private Integer position;

    public Player(String name) {
        this.name  =name;
        this.position = 0;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
