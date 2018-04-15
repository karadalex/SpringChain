package com.alexkaradimos.blockchain.models;

import java.util.ArrayList;

/**
 * Created by karadalex on 14/4/2018.
 */
public class Blockchain {

    static ArrayList<Block> blocks;
    static int latestIndex;

    public Blockchain() {
        if (blocks == null) {
            blocks = new ArrayList<Block>();
            createGenesisBlock();
            latestIndex = 0;
        }
    }

    private void createGenesisBlock() {
        blocks.add(new Block(0, "0", "GenesisBlock"));
    }

    public static ArrayList<Block> getBlocks() {
        return blocks;
    }

    public static Block getLatestBlock() {
        return blocks.get(latestIndex);
    }

    public static int getLatestIndex() {
        return latestIndex;
    }

    public static void addBlock(String data) {
        String prevHash = getLatestBlock().getHash();
        Block newBlock = new Block(++latestIndex, prevHash, data);
        blocks.add(newBlock);
    }

    public Boolean isChainValid() {
        return true;
    }
}
