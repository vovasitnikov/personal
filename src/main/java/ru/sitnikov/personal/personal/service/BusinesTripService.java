package ru.sitnikov.personal.personal.service;

import ru.sitnikov.personal.personal.dto.BusinesTripDto;
import ru.sitnikov.personal.personal.model.BusinesTripModel;

import java.time.LocalDate;
import java.util.List;

public interface BusinesTripService {

    BusinesTripDto save(BusinesTripDto businesTripDto);

    void update(BusinesTripDto businesTripDto);

    void delete(Long id);

    BusinesTripDto getById(Long id);

    List<BusinesTripDto> getAll();

    List<BusinesTripModel> selectBusinesTripsByDate(LocalDate beginTrip);

    List<BusinesTripModel> selectBusinesTripUsersByLastname(String lastname);
}
