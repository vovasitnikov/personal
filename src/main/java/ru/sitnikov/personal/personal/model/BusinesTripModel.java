package ru.sitnikov.personal.personal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "businesTrips")
public class BusinesTripModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "busines_trip_seq_generator")
    @SequenceGenerator(name = "busines_trip_seq_generator", sequenceName = "busines_trip_seq", allocationSize = 1)
    private Long id;

    @Column(name = "begin_trip")
    private LocalDate beginTrip;

    @Column(name = "end_trip")
    private LocalDate endTrip;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "idContract", nullable = false)
    private  ContractModel contractModel;
}
