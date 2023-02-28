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
public class Customer {
    @Id
    private String c_id;
    private String c_name;
    private String c_email;
    private String c_nic;
    private String c_license_no;
    private String c_contact_no;
    private String c_address;
    private String c_username;
    private String c_password;
    private String c_nic_img;
    private String c_license_img;
}
