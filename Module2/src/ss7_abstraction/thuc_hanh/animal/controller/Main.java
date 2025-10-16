package ss7_abstraction.thuc_hanh.animal.controller;
import ss7_abstraction.thuc_hanh.animal.entity.*;
import ss7_abstraction.thuc_hanh.animal.service.iEdibleService;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Chicken();
        animals[1] = new Tiger();
        for (Animal animal : animals) {
            animal.makeSound();

            if (animal instanceof Chicken) {
                iEdibleService edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();

        for (Fruit fruit: fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
