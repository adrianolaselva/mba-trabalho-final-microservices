package br.com.fiap.microservices.controllers;

import br.com.fiap.microservices.dto.TransactionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TransactionControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testTransactionCreated() throws Exception {

		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setTimestamp(Instant.now().toEpochMilli());
		transactionDTO.setAmount(2500000.50);

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		String jsonInString = mapper.writeValueAsString(transactionDTO);

		mvc.perform(post("/transactions")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonInString)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void testTransactionNoContent() throws Exception {

		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setTimestamp(Instant.now().toEpochMilli() - 1000000000);

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		String jsonInString = mapper.writeValueAsString(transactionDTO);

		mvc.perform(post("/transactions")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonInString)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
