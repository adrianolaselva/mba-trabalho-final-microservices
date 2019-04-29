package br.com.fiap.microservices.controllers;

import br.com.fiap.microservices.dto.StatisticDTO;
import com.wordnik.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("statistics")
@Api(value = "statistic", description = "Statistic Service REST API")
public class StatisticController {


    @GetMapping
    public ResponseEntity load() {

        StatisticDTO statistic = new StatisticDTO();

        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

}
