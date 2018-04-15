package com.alexkaradimos.blockchain.models;

import com.alexkaradimos.blockchain.helpers.StringUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static com.alexkaradimos.blockchain.models.Blockchain.difficulty;

/**
 * Created by karadalex on 14/4/2018.
 */
public class Block {

    private int index;
    private String timestamp;
    private String previousHash;
    private String data;
    private int nonce;
    private String hash;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public Block(int index, String previousHash, String data) {
        this.index = index;

        Timestamp time = new Timestamp(System.currentTimeMillis());
        this.timestamp = sdf.format(time);

        this.previousHash = previousHash;
        this.data = data;
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
        String calculatedhash = StringUtil.applySha256(
                previousHash + timestamp + data + nonce
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
        return this;
    }

    @Override
    public String toString() {
        return "Block {\n\tindex: " + getIndex() +
                ",\n\ttimeStamp: " + getTimestamp() +
                ",\n\tpreviousHash: " + getPreviousHash() +
                ",\n\tdata: " + getData() +
                ",\n\tnonce: " + getNonce() +
                ",\n\thash: " + getHash() +
                "\n}";
    }
}
