package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "customer", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil registerCustomer(@RequestPart("file") MultipartFile[] file, @RequestPart("customer") CustomerDTO customerDTO) {

        customerDTO.setC_license_img("uploads/" + customerDTO.getC_license_img());
        customerDTO.setC_nic_img("uploads/" + customerDTO.getC_nic_img());

        customerService.SignUpCustomer(customerDTO);


        /*for (MultipartFile myFile : file) {

            try {
                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
                File uploadsDir = new File(projectPath + "/uploads");
                uploadsDir.mkdir();
                myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));

            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                return new ResponseUtil("500", "Registration Failed.Try Again Latter", null);
            }
        }*/


        return new ResponseUtil("200", "Registration Successfully....", customerDTO);
    }


}
