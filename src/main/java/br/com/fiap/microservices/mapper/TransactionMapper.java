package br.com.fiap.microservices.mapper;

import br.com.fiap.microservices.dto.TransactionDTO;
import br.com.fiap.microservices.model.Transaction;
import lombok.*;
import org.mapstruct.Mapper;

import javax.validation.constraints.NotNull;
import java.util.List;

@Mapper
public interface TransactionMapper {

    TransactionDTO toTransactionDTO(Transaction transaction);

    List<TransactionDTO> toTransactionDTOs(List<Transaction> transactions);

    Transaction toTransaction(TransactionDTO transactionDTO);

}
