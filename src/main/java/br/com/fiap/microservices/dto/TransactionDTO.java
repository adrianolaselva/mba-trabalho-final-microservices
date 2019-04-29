package br.com.fiap.microservices.dto;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Transaction")
public class TransactionDTO {

    @ApiModelProperty("tempo da transação em millisegundos no timezone UTC")
    @NotNull(message = "Campo 'timestamp' é obrigatório")
    private Long timestamp;

    @ApiModelProperty("valor da transação")
    @NotNull(message = "Campo 'amount' é obrigatório")
    private Double amount;

}
