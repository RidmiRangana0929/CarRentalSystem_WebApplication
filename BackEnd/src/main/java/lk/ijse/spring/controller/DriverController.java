package lk.ijse.spring.controller;


import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverService service;


    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto) {
        service.addDriver(dto);
        return new ResponseUtil("200",dto.getD_id()+"Added.!",null);
    }

    @PostMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        service.updateDriver(dto);
        return new ResponseUtil("200",dto.getD_id()+": Updated.!",null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteDriver(String id){
        service.deleteDriver(id);
        return new ResponseUtil("200",id+": Deleted..!",null);
    }

    @GetMapping
    public ResponseUtil getAllDrivers(){
        ArrayList<DriverDTO> allDrivers= service.getAllDrivers();
        return new ResponseUtil("200","Success..!",allDrivers);
    }

    @GetMapping(params = "name")
    public ResponseUtil searchDriverByName(String name){
        DriverDTO driver=service.searchDriverByName(name);
        return new ResponseUtil("200","success..!",driver);
    }

}
