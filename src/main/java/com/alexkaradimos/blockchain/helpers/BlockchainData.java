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

    public ArrayList<SubBlockchain> getSubBlockchains() {
        subBlockchains = Blockchain.getSubBlockchains();
        return subBlockchains;
    }

    public int getLatestIndex() {
        latestIndex = Blockchain.getLatestIndex();
        return latestIndex;
    }

    public int getDifficulty() {
        difficulty = Blockchain.getDifficulty();
        return difficulty;
    }

    public Boolean isChainValid() {
        return Blockchain.isChainValid();
    }
}
