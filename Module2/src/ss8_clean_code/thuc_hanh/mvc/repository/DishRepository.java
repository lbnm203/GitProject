package ss8_clean_code.thuc_hanh.mvc.repository;


import ss8_clean_code.thuc_hanh.mvc.entity.Dish;

public class DishRepository {

    private static Dish[] dishes = new Dish[100];

    static {
        dishes[0] = new Dish(1, "Gà chiến mắm", 200000, "Siêu ngon");
    }

    public Dish[] getDishes() {
        return dishes;
    }
}
