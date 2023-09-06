package ru.sitnikov.personal.personal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitnikov.personal.personal.dto.ContractDto;
import ru.sitnikov.personal.personal.model.ContractModel;
import ru.sitnikov.personal.personal.repository.ContractRepository;

import java.util.List;
import java.util.stream.Collectors;

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
        contractRepository.save(toContract(contractDto));
    }

    @Override
    public void delete(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public ContractDto getById(Long id) {
        ContractModel contract = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Contract with id " + id + " not found")));
        return toContractDto(contract);
    }

    @Override
    public List<ContractDto> getAll() {
        return contractRepository.findAll().stream().map(this::toContractDto).collect(Collectors.toList());
    }

    private ContractModel toContract(ContractDto dto) {
        return new ContractModel(dto.getId(), dto.getCipherContract(), dto.getNameContract());
    }

    private ContractDto toContractDto(ContractModel contract) {
        return new ContractDto(contract.getId(), contract.getCipherContract(), contract.getNameContract());
    }
}
