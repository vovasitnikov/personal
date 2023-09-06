package ru.sitnikov.personal.personal.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitnikov.personal.personal.dto.ContractDto;
import ru.sitnikov.personal.personal.service.ContractServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/contracts")
@AllArgsConstructor
public class ContractController {

    private final ContractServiceImpl contractService;
    @PostMapping("/add")
    public ResponseEntity<ContractDto> createUser(@RequestBody ContractDto contract) {
        return ResponseEntity.ok(contractService.save(contract));
    }

    @GetMapping("/{id}")
    public ContractDto getById(@PathVariable Long id) {
        return contractService.getById(id);
    }

    @PostMapping("/all")
    public List<ContractDto> getAll() {
        return contractService.getAll();
    }


    @PutMapping("/update")
    public ResponseEntity update(@RequestBody ContractDto contract) {
        if (contract.getId() == null || contract.getId() == 0) {
            return new ResponseEntity("У контракта нет айдишника", HttpStatus.NOT_ACCEPTABLE);
        }
        contractService.update(contract);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        contractService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
