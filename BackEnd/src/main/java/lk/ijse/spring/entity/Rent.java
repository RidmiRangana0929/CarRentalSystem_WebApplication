package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

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
}
