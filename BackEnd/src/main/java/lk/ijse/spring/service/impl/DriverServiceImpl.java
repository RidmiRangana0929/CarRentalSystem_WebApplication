package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO dto) {

    }

    @Override
    public void deleteDriver(String id) {

    }

    @Override
    public void updateDriver(DriverDTO dto) {

    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return null;
    }

    @Override
    public DriverDTO searchDriverByName(String name) {
        return null;
    }
}
