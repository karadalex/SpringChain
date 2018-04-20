package com.alexkaradimos.blockchain.models;

import com.alexkaradimos.blockchain.helpers.Storage;

import java.util.ArrayList;

/**
 * Created by karadalex on 14/4/2018.
 */
public class Blockchain {

    static ArrayList<Block> blocks;
    static ArrayList<SubBlockchain> subBlockchains;
    static int latestIndex;
    static int difficulty = 5;

    public Blockchain() {
        if (blocks == null) {
            blocks = new ArrayList<Block>();
            createGenesisBlock();
            latestIndex = 0;
        }
        if (subBlockchains == null) {
            subBlockchains = new ArrayList<SubBlockchain>();
        }
    }

    private void createGenesisBlock() {
        blocks.add(new Block(0, "0", "GenesisBlock"));
    }

    public static ArrayList<Block> getBlocks() {
        return blocks;
    }

    public static ArrayList<SubBlockchain> getSubBlockchains() {
        return subBlockchains;
    }

    public static Block getLatestBlock() {
        return blocks.get(latestIndex);
    }

    public static int getLatestIndex() {
        return latestIndex;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static Block addBlock(String data) {
        String prevHash = getLatestBlock().getHash();
        Block newBlock = new Block(++latestIndex, prevHash, data);
        blocks.add(newBlock);
        Storage.backupBlockchain();
        return newBlock;
    }

    public static SubBlockchain addSubBlockchain(int difficulty) {
        SubBlockchain subBlockchain = new SubBlockchain(difficulty);
        subBlockchains.add(subBlockchain);
        return subBlockchain;
    }

    public static int getSubBlockchainIndexFromUUID(String uuid) {
        for (int i = 0; i < subBlockchains.size(); i++) {
            if (subBlockchains.get(i).getSubBlockchainId().equals(uuid)) return i;
        }
        return -1;
    }

    public static Boolean isChainValid() {
        for (int i = 1; i < blocks.size(); i++) {
            String currentHash = blocks.get(i).getPreviousHash();
            String previousHash = blocks.get(i-1).getHash();
            if (!currentHash.equals(previousHash)) return false;
        }
        return true;
    }
}
