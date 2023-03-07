package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addCar(CarDTO dto) {
        if (repo.existsById(dto.getRegister_no())) {
            throw new RuntimeException("Car"+dto.getRegister_no()+" Already Exist..!");
        }
        repo.save(mapper.map(dto, Car.class));

    }

    @Override
    public void deleteCar(String reg_no) {

        if (!repo.existsById(reg_no)){
            throw new RuntimeException("Car "+reg_no+" Not Available to Delete..!");
        }
        repo.deleteById(reg_no);

    }

    @Override
    public void updateCar(CarDTO dto) {

        if (!repo.existsById(dto.getRegister_no())){
            throw new RuntimeException("Car "+dto.getRegister_no()+" Not Available to Update..!");
        }
        repo.save( mapper.map(dto, Car.class));

    }

    @Override
    public ArrayList<CarDTO> getAllCars() {

        return mapper.map(repo.findAll(), new TypeToken<ArrayList<CarDTO>>() {
        }.getType());

    }

    @Override
    public void uploadCarImages(String frontImgPath, String backImgPath, String sideImgPath, String interiorImgPath, String registerNo) {
        if(!repo.existsById(registerNo)){
            throw new RuntimeException("Car "+ registerNo +" Not Found");
        }
        repo.updateCarFilePaths(frontImgPath, backImgPath, sideImgPath, interiorImgPath, registerNo);
    }
}
