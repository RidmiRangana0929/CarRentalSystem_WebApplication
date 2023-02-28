package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Driver {
    @Id
    private String d_id;
    private String d_name;
    private String d_nic;
    private String d_license_no;
    private String d_contact_no;
    private String d_address;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();
}
