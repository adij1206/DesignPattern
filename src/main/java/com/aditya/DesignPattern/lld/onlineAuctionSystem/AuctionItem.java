package com.aditya.DesignPattern.lld.onlineAuctionSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class AuctionItem {

    private String id;
    private String description;
    private String creatorUserId;
    private double currentPrice;
    private double initialPrice;
    private String currentBidder;
    private Long startTime;
    private Long endTime;
    private String status;

    public AuctionItem(String description, String creatorUserId, double initialPrice, Long startTime, Long endTime) {
        this.id  = UUID.randomUUID().toString();
        this.description = description;
        this.creatorUserId = creatorUserId;
        this.initialPrice = initialPrice;
        this.currentPrice = initialPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = AuctionStatus.ACTIVE.name();
    }

    public synchronized void placeBid(Bid bid) {
        if (this.getStatus().equals(AuctionStatus.COMPLETED.name())) {
            System.out.println("Auction completed!");
            return;
        }

        if (this.getCurrentPrice() > bid.getPrice()) {
            System.out.println("Cannot Place the Bid!");
            return;
        }

        this.setCurrentPrice(bid.getPrice());
        this.setCurrentBidder(bid.getUserId());

        System.out.println("Placed the Bid!" + bid.getUserId());
    }
}
