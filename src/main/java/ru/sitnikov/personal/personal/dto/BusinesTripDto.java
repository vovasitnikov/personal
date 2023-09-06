package ru.sitnikov.personal.personal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sitnikov.personal.personal.model.ContractModel;
import ru.sitnikov.personal.personal.model.UserModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinesTripDto {

    private Long id;
    private LocalDate beginTrip;
    private LocalDate endTrip;
    private UserModel userModel;
    private ContractModel contractModel;
}
