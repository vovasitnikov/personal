package ru.sitnikov.personal.personal.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import ru.sitnikov.personal.personal.model.ContractModel;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ContractRepositoryTest {

    @Autowired
    private ContractRepository contractRepository;

    @Test
    void createUser() {
        ContractModel contractModel = new ContractModel();
        contractModel.setCipherContract("4200.001");
        contractModel.setNameContract("Киринская");
        ContractModel saved  = contractRepository.save(contractModel);
        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertEquals("4200.001", saved.getCipherContract());
        assertEquals("Киринская", saved.getNameContract());
    }

    @Test
    void updateUser() {
        Optional<ContractModel> contractToUpdate = contractRepository.findById(1);
        assertNotNull(contractToUpdate);
        ContractModel userModelToUpdate = contractToUpdate.get();
        userModelToUpdate.setNameContract("new name");
        ContractModel saved  = contractRepository.save(userModelToUpdate);
        assertNotNull(saved);
        Optional<ContractModel> contractToUpdate2 = contractRepository.findById(1);
        assertEquals("new name", contractToUpdate2.get().getNameContract());
    }

    @Test
    void getContractById() {
        Optional<ContractModel> contractFromDB = contractRepository.findById(1);
        assertNotNull(contractFromDB);
        assertEquals("0042.001", contractFromDB.get().getCipherContract());
    }

    @Test
    void getAllUsers() {
        List<ContractModel> contractList = contractRepository.findAll();
        assertFalse(contractList.isEmpty());
    }

    @Test
    void deleteUser() {
        contractRepository.deleteById(1);
        Optional<ContractModel> contractModel = contractRepository.findById(1);
        assertTrue(contractModel.isEmpty());
    }

}