package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.RentDTO;

import java.util.ArrayList;

public interface RentService {
    public void addRent(RentDTO dto);

    public void deleteRent(String id);

    public void updateRent(RentDTO dto);

    public ArrayList<RentDTO> getAllRents();
}
