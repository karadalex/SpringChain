package com.alexkaradimos.blockchain;

import com.alexkaradimos.blockchain.models.Blockchain;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by karadalex on 15/4/2018.
 */
public class BlockchainInstancesTest {

    @Test
    public void blockchainIsStatic() {
        System.out.println("Testing if Blockchain data is static, from different instances");
        Blockchain springChain1 = new Blockchain();
        springChain1.addBlock("data1");
        Assert.assertEquals(springChain1.getLatestIndex(), 1);

        Blockchain springChain2 = new Blockchain();
        Assert.assertEquals(springChain2.getLatestIndex(), 1);
        springChain2.addBlock("data2");
        Assert.assertEquals(springChain2.getLatestIndex(), 2);

        Blockchain springChain3 = new Blockchain();
        springChain3.addBlock("data3");
        Assert.assertEquals(springChain3.getLatestIndex(), 3);
    }
}
