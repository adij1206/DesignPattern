package com.aditya.DesignPattern.lld.onlineAuctionSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BidService {

    private Map<String, Bid> bidMap;

    public BidService() {
        bidMap = new HashMap<>();
    }

    public void addBid(Bid bid) {
        this.bidMap.put(bid.getBidId(), bid);
    }

    public Bid getBid(String bid) {
        return this.bidMap.get(bid);
    }

    public List<Bid> getAllBidByAuctionId(String auctionId) {
        List<Bid> bidList = new ArrayList<>();

        for (Bid bid : bidMap.values()) {
            if (bid.getAuctionItemId().equals(auctionId)) {
                bidList.add(bid);
            }
        }

        return bidList;
    }
}
