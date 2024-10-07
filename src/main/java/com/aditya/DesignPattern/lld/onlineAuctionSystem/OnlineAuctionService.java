package com.aditya.DesignPattern.lld.onlineAuctionSystem;

import java.util.List;

public class OnlineAuctionService {

    private static OnlineAuctionService instance;

    private AuctionService auctionService;
    private UserService userService;
    private BidService bidService;

    private OnlineAuctionService() {
        auctionService = new AuctionService();
        userService = new UserService();
        bidService = new BidService();
    }

    public synchronized static OnlineAuctionService getInstance() {
        if (instance == null) {
            instance = new OnlineAuctionService();
        }

        return instance;
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public boolean validateUser(String id, String password) {
        return userService.validateUser(id, password);
    }

    public void addBid(Bid bid) {
        auctionService.updateBidInAuctionItem(bid);
        bidService.addBid(bid);
    }

    public AuctionItem createAuction(
            String description, String creatorUserId, double initialPrice, Long startTime, Long endTime
    ) {
        return auctionService.createAuction(description, creatorUserId, initialPrice, startTime, endTime);
    }

    public void runBackGroundJobToCheckIfAuctionHasToEnd() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    List<AuctionItem> auctionItems = auctionService.getAuctionItems();

                    Long currentTime = System.currentTimeMillis();

                    for (AuctionItem auctionItem : auctionItems) {
                        if (auctionItem.getEndTime() <= currentTime) {
                            auctionService.markAuctionAsCompleted(auctionItem.getId());
                        }
                    }
                }
            }
        }).start();
    }

    public User getWinnerForAuction(String auctionId) {
        String userId = auctionService.getWinnerForCompletedAuction(auctionId);

        if (userId == null) {
            System.out.println("Auction is Either not completed or no one has placed a bid");
        }

        return userService.getUser(userId);
    }
}
