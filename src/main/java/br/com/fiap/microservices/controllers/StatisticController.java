package br.com.fiap.microservices.controllers;

import br.com.fiap.microservices.dto.StatisticDTO;
import br.com.fiap.microservices.model.Transaction;
import br.com.fiap.microservices.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("statistics")
public class StatisticController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public ResponseEntity load() {

        List<Transaction> transactions = transactionRepository.findAll();

        /**
         * TODO: Filtrar últimos 60 segundos
         */

        StatisticDTO statistic = new StatisticDTO();

        DoubleSummaryStatistics doubleSummaryStatistics = transactions
                .stream()
                .filter(t -> !Instant.now().minusSeconds(60).isAfter(Instant.ofEpochMilli(t.getTimestamp())))
                .collect(Collectors.summarizingDouble(Transaction::getAmount));

        statistic.setSum(doubleSummaryStatistics.getSum());
        statistic.setMin(doubleSummaryStatistics.getMin());
        statistic.setMax(doubleSummaryStatistics.getMax());
        statistic.setAvg(doubleSummaryStatistics.getAverage());
        statistic.setCount(doubleSummaryStatistics.getCount());

        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

}
