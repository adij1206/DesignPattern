package com.aditya.DesignPattern.lld.onlineAuctionSystem;

public class Demo {

    /*
     * Here we have made the placeBid method synchronised as we don't want
     * other user to place the bid in the same AuctionItem at the same time
     */
    public static void main(String[] args) throws InterruptedException {
        // Create User
        User user1 = new User("adb@gmail.com", "1234");
        User user2 = new User("adx@gmail.com", "1234");
        User user3 = new User("ade@gmail.com", "1234");

        OnlineAuctionService auctionService = OnlineAuctionService.getInstance();

        auctionService.addUser(user1);
        auctionService.addUser(user2);
        auctionService.addUser(user3);

        boolean b = auctionService.validateUser("adb@gmail.com", "1234");
        if (!b) {
            System.out.println("User is not valid");
        }

        AuctionItem auction = auctionService.createAuction(
                "Vintage Car",
                user1.getId(),
                1200,
                System.currentTimeMillis(),
                System.currentTimeMillis() + 2000
        );

        AuctionItem auction1 = auctionService.createAuction(
                "Vintage Car",
                user2.getId(),
                1200,
                System.currentTimeMillis(),
                System.currentTimeMillis() + 2000
        );

        auctionService.runBackGroundJobToCheckIfAuctionHasToEnd();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Bid bid1 = new Bid(auction.getId(), user2.getId(), 1300);
                auctionService.addBid(bid1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Bid bid2 = new Bid(auction.getId(), user3.getId(), 1400);
                auctionService.addBid(bid2);
            }
        });

        // By this thread , we are testing if the synchronised block is blocking this thread from writing in the system
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Bid bid2 = new Bid(auction1.getId(), user3.getId(), 1400);
                auctionService.addBid(bid2);
                System.out.println("Done");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(100);
        Bid bid3 = new Bid(auction.getId(), user2.getId(), 1350);
        auctionService.addBid(bid3);

        auctionService.getWinnerForAuction(auction.getId());

        Thread.sleep(4000);

        System.out.println(auctionService.getWinnerForAuction(auction.getId()));
        System.out.println(auctionService.getWinnerForAuction(auction1.getId()));
    }
}
