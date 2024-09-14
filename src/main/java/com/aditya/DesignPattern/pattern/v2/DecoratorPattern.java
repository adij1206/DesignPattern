package com.aditya.DesignPattern.pattern.v2;


/*
 * DecoratorPattern : base-object is decorated with new features.
 * Decorator class will have has-a and is-a relationship with BaseClass
 */

public class DecoratorPattern {

    public static void main(String[] args) {
        BasePizza margherita = new Margherita();
        System.out.println(margherita.cost());

        BasePizza margheritaWithMushroom = new MushroomToppings(new Margherita());
        System.out.println(margheritaWithMushroom.cost());
    }
}

abstract class BasePizza {

    abstract int cost();
}

class Margherita extends BasePizza {

    @Override
    int cost() {
        return 100;
    }
}

class VegPizza extends BasePizza {

    @Override
    int cost() {
        return 150;
    }
}

abstract class ToppingDecorator extends BasePizza {

}

class ExtraCheeseToppings extends ToppingDecorator {

    BasePizza basePizza;

    public ExtraCheeseToppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    int cost() {
        return basePizza.cost() + 10;
    }
}

class MushroomToppings extends ToppingDecorator {

    BasePizza basePizza;

    public MushroomToppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    int cost() {
        return basePizza.cost() + 15;
    }
}