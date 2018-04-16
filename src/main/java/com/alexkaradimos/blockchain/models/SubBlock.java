package com.alexkaradimos.blockchain.models;

import com.alexkaradimos.blockchain.helpers.StringUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by karadalex on 16/4/2018.
 */
public class SubBlock {

    private int index;
    private String timestamp;
    private String previousHash;
    private String stringData;
    private int nonce;
    private String hash;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public SubBlock(int index, String previousHash, String stringData) {
        this.index = index;

        Timestamp time = new Timestamp(System.currentTimeMillis());
        this.timestamp = sdf.format(time);

        this.previousHash = previousHash;
        this.stringData = stringData;
        this.nonce = 0;
        this.hash = calculateHash();
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

    @Override
    public String toString() {
        return "SubBlock {\n\t\t\t\tindex: " + getIndex() +
                ",\n\t\t\t\ttimeStamp: " + getTimestamp() +
                ",\n\t\t\t\tpreviousHash: " + getPreviousHash() +
                ",\n\t\t\t\tdata: " + getStringData() +
                ",\n\t\t\t\tnonce: " + getNonce() +
                ",\n\t\t\t\thash: " + getHash() +
                "\n\t\t\t}";
    }
}
