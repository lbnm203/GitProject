package ss5_access_modifier.thuc_hanh.static_property;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "V8");
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Honda", "Civic");
        System.out.println(Car.numberOfCars);
    }
}
