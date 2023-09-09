package ru.sitnikov.personal.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sitnikov.personal.personal.model.BusinesTripModel;
import ru.sitnikov.personal.personal.model.UserModel;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BusinesTripRepository extends JpaRepository<BusinesTripModel, Long> {

    @Query("SELECT bt from BusinesTripModel bt where bt.beginTrip > :beginDate")
    List<BusinesTripModel> selectBusinesTripsByDate(@Param("beginDate")LocalDate begin);

    @Query("SELECT bt FROM BusinesTripModel bt where lower(bt.userModel.lastName) like lower(concat('%', :lastName,'%'))")
    List<BusinesTripModel> selectBusinesTripUsersByLastname(@Param("lastName") String lastName);
}
