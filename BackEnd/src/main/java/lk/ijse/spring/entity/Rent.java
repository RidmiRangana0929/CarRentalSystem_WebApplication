package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Rent {
    @Id
    private String r_id;
    private String r_date;
    private String r_pickup;
    private String r_return;
    private String r_service;
    private String r_bank_slip_img;

    @ManyToOne
    @JoinColumn(name="cus_nic", referencedColumnName = "c_nic",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="reg_no", referencedColumnName = "register_no",nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name="driver_id", referencedColumnName = "d_id")
    private Driver driver;

}
