package ss8_clean_code.thuc_hanh.mvc.controller;

import ss8_clean_code.thuc_hanh.mvc.entity.Dish;
import ss8_clean_code.thuc_hanh.mvc.service.DishService;
import ss8_clean_code.thuc_hanh.mvc.service.IService;

public class MenuBufferController {
    private final IService iService = new DishService();

    public Dish[] getMenuBuffer() {
        return iService.findAll();
    }
}
