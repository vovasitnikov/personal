package ru.sitnikov.personal.personal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "contracts")
public class ContractModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_seq_generator")
    @SequenceGenerator(name = "contract_seq_generator", sequenceName = "contract_seq", allocationSize = 1)
    private Long id;

    @Column(name = "cipher_contract", nullable = false)
    private String cipherContract;

    @Column(name = "name_contract", nullable = false)
    private String nameContract;

}
