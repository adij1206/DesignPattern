package com.aditya.DesignPattern.lld.snakeAndLadder;

public class Snake {

    private Integer start;
    private Integer end;

    public Snake(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public Integer getStart() {
        return this.start;
    }

    public Integer getEnd() {
        return this.end;
    }
}
