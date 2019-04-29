package br.com.fiap.microservices.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDTO {

    private Double sum;

    private Double min;

    private Double max;

    private Double avg;

    private Long count;

}
