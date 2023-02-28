package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDTO {
    private String r_id;
    private String r_date;
    private String r_pickup;
    private String r_return;
    private String r_service;
    private String r_bank_slip_img;
}
