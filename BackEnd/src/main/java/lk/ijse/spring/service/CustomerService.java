package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);

    public ArrayList<CustomerDTO> getAllCustomers();

    public void uploadCustomerImages(String nicImgPath, String licenseImgPath, String id);
}
