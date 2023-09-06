package ru.sitnikov.personal.personal.dto;

import ru.sitnikov.personal.personal.model.ContractModel;
import ru.sitnikov.personal.personal.model.UserModel;

import java.time.LocalDate;

public class BusinesTripDto {

    private Long id;
    private LocalDate beginTrip;
    private LocalDate endTrip;
    private UserModel userModel;
    private ContractModel contractModel;
}
