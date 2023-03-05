package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getC_nic())) {
            throw new RuntimeException("Customer "+dto.getC_nic()+" Already Exist..!");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return null;
    }
}
