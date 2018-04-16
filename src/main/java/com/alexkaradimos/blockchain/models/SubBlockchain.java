package com.alexkaradimos.blockchain.models;

import java.util.ArrayList;

/**
 * Created by karadalex on 16/4/2018.
 */
public class SubBlockchain {

    public ArrayList<SubBlock> subBlocks;
    static int latestIndex;
    static int difficulty = 5;

    public SubBlockchain() {
        if (subBlocks == null) {
            subBlocks = new ArrayList<SubBlock>();
            createGenesisBlock();
            latestIndex = 0;
        }
    }

    private void createGenesisBlock() {
        subBlocks.add(new SubBlock(0, "0", "GenesisSubBlock"));
    }

    public ArrayList<SubBlock> getSubBlocks() {
        return subBlocks;
    }

    public SubBlock getLatestSubBlock() {
        return subBlocks.get(latestIndex);
    }

    public static int getLatestIndex() {
        return latestIndex;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public SubBlock addSubBlock(String data) {
        String prevHash = getLatestSubBlock().getHash();
        SubBlock newBlock = new SubBlock(++latestIndex, prevHash, data);
        subBlocks.add(newBlock);
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

}
