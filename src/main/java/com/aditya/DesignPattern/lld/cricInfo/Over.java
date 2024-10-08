package com.aditya.DesignPattern.lld.cricInfo;

import lombok.Data;

import java.util.UUID;

@Data
public class Over {

    private String id;
    private String overNumber;
    private String inningId;

    public Over(String overNumber, String inningId) {
        this.id = UUID.randomUUID().toString();
        this.overNumber = overNumber;
        this.inningId = inningId;
    }
}
