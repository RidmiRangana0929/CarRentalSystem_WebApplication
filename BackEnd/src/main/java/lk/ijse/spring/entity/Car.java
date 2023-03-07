package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Car {
    @Id
    private String register_no;
    private String brand;
    private String type;
    private int no_of_passengers;
    private String transmission_type;
    private String fuel_type;
    private String color;
    private double daily_rate;
    private int km_for_day;
    private double monthly_rate;
    private int km_for_month;
    private double price_for_extra_km;
    private double loss_damage_waiver;
    private String front_img;
    private String back_img;
    private String side_img;
    private String interior_img;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();

}
