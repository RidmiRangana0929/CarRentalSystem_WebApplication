package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void SignUpCustomer(CustomerDTO dto);

    public ArrayList<CustomerDTO> getAllCustomers();
}
