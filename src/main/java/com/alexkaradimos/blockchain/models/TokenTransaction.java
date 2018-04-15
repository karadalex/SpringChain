package com.alexkaradimos.blockchain.models;

/**
 * Created by karadalex on 16/4/2018.
 */
public class TokenTransaction implements TokenStandardTransactionInterface {
    @Override
    public long totalSupply() {
        return 0;
    }

    @Override
    public long balanceOf(String owner) {
        return 0;
    }

    @Override
    public long allowance(String owner, String spender) {
        return 0;
    }

    @Override
    public Boolean transfer(String to, long tokens) {
        return null;
    }

    @Override
    public Boolean approve(String spender, long tokens) {
        return null;
    }

    @Override
    public Boolean transferFrom(String from, String to, long tokens) {
        return null;
    }
}
