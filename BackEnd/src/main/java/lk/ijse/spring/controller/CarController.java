package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService service;


    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto) {
        service.addCar(dto);
        return new ResponseUtil("200",dto.getRegister_no()+"Added.!",null);
    }

    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO dto){
        service.updateCar(dto);
        return new ResponseUtil("200",dto.getRegister_no()+": Updated.!",null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteCar(String id){
        service.deleteCar(id);
        return new ResponseUtil("200",id+": Deleted..!",null);
    }

    @GetMapping
    public ResponseUtil getAllCars(){
        ArrayList<CarDTO> allCars= service.getAllCars();
        return new ResponseUtil("200","Success..!",allCars);
    }
}
