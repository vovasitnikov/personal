package ru.sitnikov.personal.personal.service;

import ru.sitnikov.personal.personal.dto.BusinesTripDto;

import java.util.List;

public interface BusinesTripService {

    BusinesTripDto save(BusinesTripDto businesTripDto);

    void update(BusinesTripDto businesTripDto);

    void delete(Long id);

    BusinesTripDto getById(Long id);

    List<BusinesTripDto> getAll();
}
