package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CarRepo extends JpaRepository<Car,String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Car SET front_img=?1 , back_img=?2 , side_img=?3 , interior_img=?4 WHERE register_no=?5")
    void updateCarFilePaths(String front_img, String back_img, String side_img, String interior_img, String register_no);
}
