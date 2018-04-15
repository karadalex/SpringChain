package com.alexkaradimos.blockchain.models;

/**
 * Created by karadalex on 16/4/2018.
 */
public class TokenTransaction implements TokenStandardTransactionInterface {

    public final String name = "Spring Token";
    public final String symbol = "SPR";
    public final int decimals = 18;


    @Override
    public long totalSupply() {
        // TODO calculate based on supply-demand
        return (long) Math.pow(10, 12);
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
