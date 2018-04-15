package com.alexkaradimos.blockchain.models;

/**
 * Created by karadalex on 16/4/2018.
 *
 * Token Transaction interface based on
 * the ERC20 standard
 */
public interface TokenStandardTransactionInterface {

    /**
     *
     * @return
     */
    public long totalSupply();

    /**
     *
     * @param owner
     * @return
     */
    public long balanceOf(String owner);

    /**
     *
     * @param owner
     * @param spender
     * @return
     */
    public long allowance(String owner, String spender);

    /**
     *
     * @param to
     * @param tokens
     * @return
     */
    public Boolean transfer(String to, long tokens);

    /**
     *
     * @param spender
     * @param tokens
     * @return
     */
    public Boolean approve(String spender, long tokens);

    /**
     *
     * @param from
     * @param to
     * @param tokens
     * @return
     */
    public Boolean transferFrom(String from, String to, long tokens);
}
