package br.com.fiap.microservices.controllers;

import br.com.fiap.microservices.dto.StatisticDTO;
import br.com.fiap.microservices.dto.TransactionDTO;
import br.com.fiap.microservices.mapper.TransactionMapper;
import br.com.fiap.microservices.model.Transaction;
import br.com.fiap.microservices.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public ResponseEntity all() {

        Iterable<Transaction> transactions = transactionRepository.findAll();

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TransactionDTO transactionDTO) {

        Transaction transaction = new Transaction();

        transaction.setTimestamp(transactionDTO.getTimestamp());
        transaction.setAmount(transactionDTO.getAmount());

        log.info("transação {}", Instant.now().minusSeconds(60).toString());
        log.info("transação {}", Instant.ofEpochMilli(transaction.getTimestamp()).toString());

        if(Instant.now().minusSeconds(60).isAfter(Instant.ofEpochMilli(transaction.getTimestamp())))
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        transactionRepository.save(transaction);

        return new ResponseEntity<>(transactionDTO, HttpStatus.CREATED);
    }

}
