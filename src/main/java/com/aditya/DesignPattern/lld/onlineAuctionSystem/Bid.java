package com.aditya.DesignPattern.lld.onlineAuctionSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Bid {

    private String bidId;
    private String auctionItemId;
    private String userId;
    private double price;

    public Bid(String auctionItemId, String userId, double price) {
        this.bidId = UUID.randomUUID().toString();
        this.auctionItemId = auctionItemId;
        this.userId = userId;
        this.price = price;
    }
}
