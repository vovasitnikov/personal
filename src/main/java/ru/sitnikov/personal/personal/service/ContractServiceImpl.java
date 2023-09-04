package ru.sitnikov.personal.personal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitnikov.personal.personal.dto.ContractDto;
import ru.sitnikov.personal.personal.model.ContractModel;
import ru.sitnikov.personal.personal.repository.ContractRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService{

    private final ContractRepository contractRepository;

    @Override
    public ContractDto save(ContractDto contractDto) {
        ContractModel contract = contractRepository.save(toContract(contractDto));
        return toContractDto(contract);
    }

    @Override
    public void update(ContractDto contractDto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ContractDto getById(Long id) {
        return null;
    }

    @Override
    public List<ContractDto> getAll() {
        return null;
    }

    private ContractModel toContract(ContractDto dto) {
        return new ContractModel(dto.getId(), dto.getCipherContract(), dto.getNameContract());
    }

    private ContractDto toContractDto(ContractModel contract) {
        return new ContractDto(contract.getId(), contract.getCipherContract(), contract.getNameContract());
    }
}
