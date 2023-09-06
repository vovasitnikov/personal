package ru.sitnikov.personal.personal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitnikov.personal.personal.dto.BusinesTripDto;
import ru.sitnikov.personal.personal.model.BusinesTripModel;
import ru.sitnikov.personal.personal.repository.BusinesTripRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BusinesTripServiceImpl implements BusinesTripService{

    private final BusinesTripRepository businesTripRepository;


    @Override
    public BusinesTripDto save(BusinesTripDto businesTripDto) {
        BusinesTripModel businesTrip = businesTripRepository.save(toBusinesTrip(businesTripDto));
        return toBusinesTripDto(businesTrip);
    }

    @Override
    public void update(BusinesTripDto businesTripDto) {
        businesTripRepository.save(toBusinesTrip(businesTripDto));
    }

    @Override
    public void delete(Long id) {
        businesTripRepository.deleteById(id);
    }

    @Override
    public BusinesTripDto getById(Long id) {
        BusinesTripModel contract = businesTripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Contract with id " + id + " not found")));
        return toBusinesTripDto(contract);
    }

    @Override
    public List<BusinesTripDto> getAll() {
        return businesTripRepository.findAll().stream().map(this::toBusinesTripDto).collect(Collectors.toList());
    }

    private BusinesTripModel toBusinesTrip(BusinesTripDto dto) {
        return new BusinesTripModel(dto.getId(), dto.getBeginTrip(), dto.getEndTrip(), dto.getUserModel(), dto.getContractModel());
    }

    private BusinesTripDto toBusinesTripDto(BusinesTripModel businesTrip) {
        return new BusinesTripDto(businesTrip.getId(), businesTrip.getBeginTrip(), businesTrip.getEndTrip(), businesTrip.getUserModel(), businesTrip.getContractModel());
    }


}
