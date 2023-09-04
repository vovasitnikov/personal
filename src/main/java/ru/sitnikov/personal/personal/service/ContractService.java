package ru.sitnikov.personal.personal.service;

import ru.sitnikov.personal.personal.dto.ContractDto;

import java.util.List;

public interface ContractService {
    ContractDto save(ContractDto contractDto);

    void update(ContractDto contractDto);

    void delete(Long id);

    ContractDto getById(Long id);

    List<ContractDto> getAll();
}
