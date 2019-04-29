package br.com.fiap.microservices.dto;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Statistic")
public class StatisticDTO {

    @ApiModelProperty("Soma das transações")
    private Double sum;

    @ApiModelProperty("Menor transação")
    private Double min;

    @ApiModelProperty("Maior transação")
    private Double max;

    @ApiModelProperty("Média das transações")
    private Double avg;

    @ApiModelProperty("Total de transações")
    private Long count;

}
