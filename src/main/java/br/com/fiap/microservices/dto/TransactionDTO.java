package br.com.fiap.microservices.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    @NotNull(message = "Campo 'timestamp' é obrigatório")
    private Long timestamp;

    @NotNull(message = "Campo 'amount' é obrigatório")
    private Double amount;

}
