package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService service;


    @PostMapping
    public ResponseUtil saveCar(@RequestBody CarDTO dto) {
        service.addCar(dto);
        return new ResponseUtil("200",dto.getRegister_no()+"Added.!",null);
    }

    /*@PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO dto){
        service.updateCar(dto);
        return new ResponseUtil("200",dto.getRegister_no()+": Updated.!",null);
    }*/

    @PutMapping(path = "/up/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("front_img") MultipartFile frontImg, @RequestPart("back_img")MultipartFile backImg,@RequestPart("side_img") MultipartFile sideImg,@RequestPart("interior_img") MultipartFile interiorImg, @PathVariable String id) {
        try {
            String projectPath = String.valueOf(new File("C:\\Users\\ridhm\\GDSE59\\SpringFinal\\CarRentalSystem\\FrontEnd\\assets\\savedImages"));
            File uploadsDir = new File(projectPath + "/cars");
            uploadsDir.mkdir();

            frontImg.transferTo(new File(uploadsDir.getAbsolutePath() + "//" + frontImg.getOriginalFilename()));
            backImg.transferTo(new File(uploadsDir.getAbsolutePath() + "//" + backImg.getOriginalFilename()));
            sideImg.transferTo(new File(uploadsDir.getAbsolutePath() + "//" + sideImg.getOriginalFilename()));
            interiorImg.transferTo(new File(uploadsDir.getAbsolutePath() + "//" + interiorImg.getOriginalFilename()));

            String frontImgPath = projectPath + "//car//" + frontImg.getOriginalFilename();
            String backImgPath = projectPath + "//car//" + backImg.getOriginalFilename();
            String sideImgPath = projectPath + "//car//" + sideImg.getOriginalFilename();
            String interiorImgPath = projectPath + "//car//" + interiorImg.getOriginalFilename();

            service.uploadCarImages(frontImgPath, backImgPath, sideImgPath, interiorImgPath, id);

            return new ResponseUtil("200", "Uploaded", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtil("500", "Error", null);
        }
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
