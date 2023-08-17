package ru.sitnikov.personal.personal.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import ru.sitnikov.personal.personal.model.ContractModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ContractRepositoryTest {

    @Autowired
    private ContractRepository contractRepository;

    @Test
    void getContractById() {
        Optional<ContractModel> contractFromDB = contractRepository.findById(1);
        assertNotNull(contractFromDB);
        assertEquals("0042.001", contractFromDB.get().getCipherContract());
    }


}