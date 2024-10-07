package com.aditya.DesignPattern.lld.onlineAuctionSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuctionService {

    private Map<String, AuctionItem> map;

    public AuctionService() {
        this.map = new HashMap<>();
    }

    public AuctionItem createAuction(
            String description, String creatorUserId, double initialPrice, Long startTime, Long endTime
    ) {
        AuctionItem auctionItem = new AuctionItem(description, creatorUserId, initialPrice, startTime, endTime);
        map.put(auctionItem.getId(), auctionItem);

        return auctionItem;
    }

    public AuctionItem getAuctionItem(String id) {
        return map.get(id);
    }

    public void updateBidInAuctionItem(Bid bid) {
        AuctionItem auctionItem = map.get(bid.getAuctionItemId());

        auctionItem.placeBid(bid);
        map.put(auctionItem.getId(), auctionItem);
    }

    public void markAuctionAsCompleted(String auctionId) {
        AuctionItem auctionItem = map.get(auctionId);

        if (auctionItem.getStatus().equals(AuctionStatus.ACTIVE.name())) {
            auctionItem.setStatus(AuctionStatus.COMPLETED.name());
            map.put(auctionItem.getId(), auctionItem);
        }
    }

    public List<AuctionItem> getAuctionItems() {
        return new ArrayList<>(map.values());
    }

    public String getWinnerForCompletedAuction(String auctionId) {
        AuctionItem auctionItem = map.get(auctionId);

        if (auctionItem.getStatus().equals(AuctionStatus.COMPLETED.name())) {
            return auctionItem.getCurrentBidder();
        }

        return null;
    }
}
