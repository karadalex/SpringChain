package com.alexkaradimos.blockchain;

import com.alexkaradimos.blockchain.helpers.Storage;
import com.alexkaradimos.blockchain.models.Blockchain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockchainApplication {

	public static void main(String[] args) {
		new Blockchain();
		Storage.deserializeBlockchain();

		SpringApplication.run(BlockchainApplication.class, args);
	}
}
