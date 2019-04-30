package br.com.fiap.microservices.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @NotNull(message = "Campo 'timestamp' é obrigatório")
    private Long timestamp;

    @NotNull(message = "Campo 'amount' é obrigatório")
    private Double amount;

}
