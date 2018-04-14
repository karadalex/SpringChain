package com.alexkaradimos.blockchain.models;

/**
 * Created by karadalex on 14/4/2018.
 */
public class Block {

    public int index;
    public String timestamp;
    public String previousHash;
    public String data;
    public int nonce;
    public String hash;

    public Block(int index, String timestamp, String previousHash, String data) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.data = data;
        this.nonce = 0;
        this.hash = "hash";
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

    public String getData() {
        return data;
    }

    public int getNonce() {
        return nonce;
    }

    public String getHash() {
        return hash;
    }

    public String calculateHash() {
        return "hash";
    }

    public void mineBlock() {

    }

}
