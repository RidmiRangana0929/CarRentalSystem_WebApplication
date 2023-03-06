package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer SET c_nic_img=?1 , c_license_img=?2 WHERE c_nic=?3")
    void updateCustomerFilePaths(String nicImg, String licenseImg, String nicNo);
}
