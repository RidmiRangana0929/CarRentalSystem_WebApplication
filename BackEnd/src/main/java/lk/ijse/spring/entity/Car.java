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
public class Car {
    @Id
    private String register_no;
    private String brand;
    private String type;
    private String no_of_passengers;
    private String transmission_type;
    private String fuel_type;
    private String color;
    private String daily_rate;
    private String km_for_day;
    private String monthly_rate;
    private String km_for_month;
    private String price_for_extra_km;
    private String loss_damage_waiver;
    private String front_img;
    private String back_img;
    private String side_img;
    private String interior_img;
}
