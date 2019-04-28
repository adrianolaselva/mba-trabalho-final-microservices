package br.com.fiap.microservices.controllers;

import br.com.fiap.microservices.dto.TransactionDTO;
import com.wordnik.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("transactions")
@Api(value = "Transaction", description = "Transaction Service REST API")
public class TransactionController {

    @PostMapping
    public ResponseEntity create(@RequestBody TransactionDTO transaction) {
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

}
