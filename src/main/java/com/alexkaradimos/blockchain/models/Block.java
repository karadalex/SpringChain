package com.alexkaradimos.blockchain.models;

import com.alexkaradimos.blockchain.helpers.Storage;
import com.alexkaradimos.blockchain.helpers.StringUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.alexkaradimos.blockchain.models.Blockchain.difficulty;

/**
 * Created by karadalex on 14/4/2018.
 */
public class Block {

    private int index;
    private String timestamp;
    private String previousHash;
    private int nonce;
    private String hash;

    // Different types of data
    private String stringData;
    private ArrayList<TokenTransaction> tokenTransactionsData;
    private ArrayList<DataTransaction> dataTransactionsData;
    private ArrayList<SubBlock> subBlocksData;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public Block(int index, String previousHash, String stringData) {
        this.index = index;

        Timestamp time = new Timestamp(System.currentTimeMillis());
        this.timestamp = sdf.format(time);

        this.previousHash = previousHash;
        this.stringData = stringData;
        this.nonce = 0;
        this.hash = calculateHash();

        this.tokenTransactionsData = new ArrayList<TokenTransaction>();
        this.dataTransactionsData = new ArrayList<DataTransaction>();
        this.subBlocksData = new ArrayList<SubBlock>();
    }

    public Block() {
        // Default constructor,
        // used in deserialization
    }

    public int getIndex() {
        return index;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getStringData() {
        return stringData;
    }

    public ArrayList<TokenTransaction> getTokenTransactionsData() {
        return tokenTransactionsData;
    }

    public ArrayList<DataTransaction> getDataTransactionsData() {
        return dataTransactionsData;
    }

    public ArrayList<SubBlock> getSubBlocksData() {
        return subBlocksData;
    }

    public int getNonce() {
        return nonce;
    }

    public String getHash() {
        return hash;
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash + timestamp + stringData + nonce
        );
        return calculatedhash;
    }

    public Block mineBlock() {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println(this.toString());
        Storage.serializeBlockchain();
        return this;
    }

    // TODO specify in which subBlockchain the newSubBlock will belong to
    public SubBlock addSubBlock(SubBlock newSubBlock) {
        subBlocksData.add(newSubBlock);
        Storage.serializeBlockchain();
        return newSubBlock;
    }

    @Override
    public String toString() {
        String subBlocksDataToString = "[\n";
        for (int i = 0; i < getSubBlocksData().size(); i++) {
            subBlocksDataToString += "\t\t\t" + getSubBlocksData().get(i).toString() + "\n";
        }
        subBlocksDataToString += "\t\t]";
        String data = "{\n\t\tstringData: " + getStringData() +
                ",\n\t\tsubBlocksData: " + subBlocksDataToString +
                "\n\t}";
        return "Block {\n\tindex: " + getIndex() +
                ",\n\ttimeStamp: " + getTimestamp() +
                ",\n\tpreviousHash: " + getPreviousHash() +
                ",\n\tdata: " + data +
                ",\n\tnonce: " + getNonce() +
                ",\n\thash: " + getHash() +
                "\n}";
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    public void setTokenTransactionsData(ArrayList<TokenTransaction> tokenTransactionsData) {
        this.tokenTransactionsData = tokenTransactionsData;
    }

    public void setDataTransactionsData(ArrayList<DataTransaction> dataTransactionsData) {
        this.dataTransactionsData = dataTransactionsData;
    }

    public void setSubBlocksData(ArrayList<SubBlock> subBlocksData) {
        this.subBlocksData = subBlocksData;
    }
}
