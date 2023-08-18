package ru.sitnikov.personal.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sitnikov.personal.personal.model.BusinesTripModel;
import ru.sitnikov.personal.personal.model.ContractModel;

@Repository
public interface BusinesTripRepository extends JpaRepository<BusinesTripModel, Integer> {
}
