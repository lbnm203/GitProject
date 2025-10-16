package ss7_abstraction.thuc_hanh.animal.entity;

import ss7_abstraction.thuc_hanh.animal.service.iEdibleService;

public class Chicken extends Animal implements iEdibleService {
    @Override
    public void makeSound() {
        System.out.println("Chicken sound");
    }

    @Override
    public String howToEat() {
        return "Chicken could be fried";
    }
}
