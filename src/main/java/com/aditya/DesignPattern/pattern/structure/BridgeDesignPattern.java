package com.aditya.DesignPattern.pattern.structure;

abstract class TV {
    abstract void on();
    abstract void off();
}

class SonyTv extends TV {

    private Remote remote;

    public SonyTv(Remote remote) {
        this.remote = remote;
    }

    @Override
    void on() {
        System.out.println("Sony TV on : ");
        remote.on();
    }

    @Override
    void off() {
        System.out.println("Sony TV off : ");
        remote.off();
    }
}

class SamsungTv extends TV {

    private Remote remote;

    public SamsungTv(Remote remote) {
        this.remote = remote;
    }

    @Override
    void on() {
        System.out.println("Samsung TV on : ");
        remote.on();
    }

    @Override
    void off() {
        System.out.println("Samsung TV off : ");
        remote.off();
    }
}

interface Remote {
    void on();
    void off();
}

class OldRemote implements Remote {

    @Override
    public void on() {
        System.out.println("OldRemote on : ");
    }

    @Override
    public void off() {
        System.out.println("OldRemote TV off : ");
    }
}

class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("NewRemote TV on : ");
    }

    @Override
    public void off() {
        System.out.println("NewRemote TV off : ");
    }
}

public class BridgeDesignPattern {

    public static void main(String[] args) {
        TV sonyTvWithOldRemote = new SonyTv(new OldRemote());
        sonyTvWithOldRemote.on();
        sonyTvWithOldRemote.off();

        TV sonyTvWithNewRemote = new SonyTv(new NewRemote());
        sonyTvWithNewRemote.on();
        sonyTvWithNewRemote.off();

        TV samsungTvWithOldRemote = new SamsungTv(new OldRemote());
        samsungTvWithOldRemote.on();
        samsungTvWithOldRemote.off();

        TV samsungTvWithNewRemote = new SamsungTv(new NewRemote());
        samsungTvWithNewRemote.on();
        samsungTvWithNewRemote.off();

        //It seems more like decorator pattern

        /*
         * Here as Tv can be various type and even Tvs remote can be of various type let say old , new
         * so to hide the implementation from client , we will use the BridgePattern
         */
    }
}
