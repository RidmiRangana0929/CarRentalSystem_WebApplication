package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

import java.util.ArrayList;

public interface CarService {
    void addCar(CarDTO dto);

    public void deleteCar(String id);

    public void updateCar(CarDTO dto);

    public ArrayList<CarDTO> getAllCars();

    public void uploadCarImages(String frontImgPath, String backImgPath, String sideImgPath, String interiorImgPath, String registerNo);
}
