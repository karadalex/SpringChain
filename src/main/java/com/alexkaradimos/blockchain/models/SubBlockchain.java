package com.alexkaradimos.blockchain.models;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by karadalex on 16/4/2018.
 */
public class SubBlockchain {

    public ArrayList<SubBlock> subBlocks;
    private String subBlockchainId;
    public int latestIndex;
    public int difficulty;

    public SubBlockchain(int difficulty) {
        if (subBlocks == null) {
            subBlocks = new ArrayList<SubBlock>();
            createGenesisBlock();
            latestIndex = 0;
        }
        this.subBlockchainId = UUID.randomUUID().toString();
        this.difficulty = difficulty;
    }

    private void createGenesisBlock() {
        SubBlock genesis = new SubBlock(0, "0", "GenesisSubBlock");
        subBlocks.add(genesis);
        // TODO: find a way to reduce duplicate subBlock
        Blockchain.getLatestBlock().addSubBlock(genesis);
    }

    public ArrayList<SubBlock> getSubBlocks() {
        return subBlocks;
    }

    public SubBlock getLatestSubBlock() {
        return subBlocks.get(latestIndex);
    }

    public String getSubBlockchainId() {
        return subBlockchainId;
    }

    public int getLatestIndex() {
        return latestIndex;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public SubBlock addSubBlock(String data) {
        String prevHash = getLatestSubBlock().getHash();
        SubBlock newBlock = new SubBlock(++latestIndex, prevHash, data);
        subBlocks.add(newBlock);
        // TODO: find a way to reduce duplicate subBlock
        Blockchain.getLatestBlock().addSubBlock(newBlock);
        return newBlock;
    }

    public Boolean isChainValid() {
        for (int i = 1; i < subBlocks.size(); i++) {
            String currentHash = subBlocks.get(i).getPreviousHash();
            String previousHash = subBlocks.get(i-1).getHash();
            if (!currentHash.equals(previousHash)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SubBlockchain{" +
                "subBlocks=" + subBlocks +
                ", subBlockchainId='" + subBlockchainId + '\'' +
                ", latestIndex=" + latestIndex +
                ", difficulty=" + difficulty +
                '}';
    }
}
