package com.alexkaradimos.blockchain.models;

import java.util.ArrayList;

/**
 * Created by karadalex on 14/4/2018.
 */
public class Blockchain {

    static ArrayList<Block> blocks;

    public Blockchain() {
        if (blocks == null) {
            blocks = new ArrayList<Block>();
            createGenesisBlock();
        }
    }

    private void createGenesisBlock() {
        blocks.add(new Block(0, "time", "0", "GenesisBlock"));
    }

    public static ArrayList<Block> getBlocks() {
        return blocks;
    }

    public static Block getLatestBlock() {
        return blocks.get(blocks.size()-1);
    }

    public void addBlock(Block newBlock) {
        blocks.add(newBlock);
    }

    public Boolean isChainValid() {
        return true;
    }
}
