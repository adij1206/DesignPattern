package com.aditya.DesignPattern.pattern.v2;

import java.util.Stack;

public class CommandPattern {

    public static void main(String[] args) {
        // AirConditioner Object
        AirConditioner airConditioner = new AirConditioner();

        // Invoker
        Invoker invoker = new Invoker();
        invoker.setCommand(new TurnOnAcCommand(airConditioner));

        invoker.pressButton();
        invoker.undo();
    }
}

class Invoker {

    Stack<ICommand> acCommandHistory = new Stack<>();
    private ICommand command;

    public Invoker() {
    }

    public void setCommand(ICommand iCommand) {
        this.command = iCommand;
    }

    public void pressButton() {
        acCommandHistory.push(command);
        command.execute();
    }

    public void undo() {
        if (!acCommandHistory.isEmpty()) {
            ICommand pop = acCommandHistory.pop();
            pop.undo();
        }
    }

}

interface ICommand {

    void execute();

    void undo();
}

class TurnOnAcCommand implements ICommand {

    private AirConditioner airConditioner;

    public TurnOnAcCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOn();
    }

    @Override
    public void undo() {
        airConditioner.turnOff();
    }
}

class TurnOffAcCommand implements ICommand {

    private AirConditioner airConditioner;

    public TurnOffAcCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }


    @Override
    public void execute() {
        airConditioner.turnOff();
    }

    @Override
    public void undo() {
        airConditioner.turnOn();
    }
}

class AirConditioner {

    private boolean isOn;
    private String temperature;

    public AirConditioner() {
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("TurnOn AC");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("TurnOff AC");
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
