package com.alexkaradimos.blockchain.models;

/**
 * Created by karadalex on 14/4/2018.
 */
public class Blockchain {

    public void createGenesisBlock() {

    }

    public Block getLatestBlock() {
        return new Block(1, "time", "prevhash", "data");
    }

    public void addBlock(Block newBlock) {
    }

    public Boolean isChainValid() {
        return true;
    }
}
