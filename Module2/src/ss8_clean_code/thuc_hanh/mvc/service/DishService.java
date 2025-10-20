package ss8_clean_code.thuc_hanh.mvc.service;


import ss8_clean_code.thuc_hanh.mvc.entity.Dish;
import ss8_clean_code.thuc_hanh.mvc.repository.DishRepository;

public class DishService implements IService{
    private DishRepository dishRepository = new DishRepository();
    @Override
    public Dish[] findAll() {
        return dishRepository.getDishes();
    }
}
