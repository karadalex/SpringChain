package com.alexkaradimos.blockchain;

import com.alexkaradimos.blockchain.models.Block;
import com.alexkaradimos.blockchain.models.Blockchain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockchainApplication {

	public static void main(String[] args) {
		Blockchain springChain1 = new Blockchain();
		System.out.println(Blockchain.getLatestBlock().toString());
		springChain1.addBlock("data1");

		Blockchain springChain2 = new Blockchain();
		System.out.println(springChain2.getLatestBlock().toString());
		springChain2.addBlock("data2");
		System.out.println(Blockchain.getLatestBlock().toString());

		Blockchain springChain3 = new Blockchain();
		springChain3.addBlock("data3");
		System.out.println(springChain3.getLatestBlock().toString());


		SpringApplication.run(BlockchainApplication.class, args);
	}
}
