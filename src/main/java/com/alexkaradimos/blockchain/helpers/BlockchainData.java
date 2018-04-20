package com.alexkaradimos.blockchain.helpers;

import com.alexkaradimos.blockchain.models.Block;
import com.alexkaradimos.blockchain.models.Blockchain;
import com.alexkaradimos.blockchain.models.SubBlockchain;

import java.util.ArrayList;

/**
 * Created by karadalex on 20/4/2018.
 */
public class BlockchainData {

    private ArrayList<Block> blocks;
    private ArrayList<SubBlockchain> subBlockchains;
    private int latestIndex;
    private int difficulty;

    public ArrayList<Block> getBlocks() {
        blocks = Blockchain.getBlocks();
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        Blockchain.setBlocks(blocks);
        this.blocks = blocks;
    }

    public ArrayList<SubBlockchain> getSubBlockchains() {
        subBlockchains = Blockchain.getSubBlockchains();
        return subBlockchains;
    }

    public void setSubBlockchains(ArrayList<SubBlockchain> subBlockchains) {
        Blockchain.setSubBlockchains(subBlockchains);
        this.subBlockchains = subBlockchains;
    }

    public int getLatestIndex() {
        latestIndex = Blockchain.getLatestIndex();
        return latestIndex;
    }

    public void setLatestIndex(int latestIndex) {
        Blockchain.setLatestIndex(latestIndex);
        this.latestIndex = latestIndex;
    }

    public int getDifficulty() {
        difficulty = Blockchain.getDifficulty();
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        Blockchain.setDifficulty(difficulty);
        this.difficulty = difficulty;
    }

    public Boolean isChainValid() {
        return Blockchain.isChainValid();
    }
}
