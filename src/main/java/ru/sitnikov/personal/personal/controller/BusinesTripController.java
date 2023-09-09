package ru.sitnikov.personal.personal.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitnikov.personal.personal.dto.BusinesTripDto;
import ru.sitnikov.personal.personal.model.BusinesTripModel;
import ru.sitnikov.personal.personal.model.UserModel;
import ru.sitnikov.personal.personal.service.BusinesTripServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/businesTrip")
@AllArgsConstructor
public class BusinesTripController {

    private final BusinesTripServiceImpl businesTripService;

    @PostMapping("/add")
    public ResponseEntity<BusinesTripDto> createBusinesTrip(@RequestBody BusinesTripDto businesTrip) {
        return ResponseEntity.ok(businesTripService.save(businesTrip));
    }

    @GetMapping("/{id}")
    public BusinesTripDto getById(@PathVariable Long id) {
        return businesTripService.getById(id);
    }

    @PostMapping("/all")
    public List<BusinesTripDto> getAll() {
        return businesTripService.getAll();
    }


    @PutMapping("/update")
    public ResponseEntity update(@RequestBody BusinesTripDto businesTrip) {
        if (businesTrip.getId() == null || businesTrip.getId() == 0) {
            return new ResponseEntity("У контракта нет айдишника", HttpStatus.NOT_ACCEPTABLE);
        }
        businesTripService.update(businesTrip);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        businesTripService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/selectByDate")
    public List<BusinesTripModel> selectBusinesTripsByDate(@RequestBody BusinesTripModel businesTripModel) {
        return businesTripService.selectBusinesTripsByDate(businesTripModel.getBeginTrip());
    }

    @PostMapping("/getByUser")
    public ResponseEntity<List<BusinesTripModel>> selectBusinesTripUsersByLastname(@RequestBody UserModel userModel){

        return ResponseEntity.ok( businesTripService.selectBusinesTripUsersByLastname(userModel.getLastName()));
    }
}
