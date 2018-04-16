package com.alexkaradimos.blockchain;

import com.alexkaradimos.blockchain.helpers.StringUtil;
import com.alexkaradimos.blockchain.models.Block;
import com.alexkaradimos.blockchain.models.Blockchain;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by karadalex on 16/4/2018.
 */
public class BlockTests {

    @Test
    public void testMining() {
        new Blockchain();
        Block block = new Block(1,"prevHash","testing mining");
        String hashAfterMining = block.mineBlock().getHash();
        int difficulty = Blockchain.getDifficulty();
        for (int i = 0; i < difficulty; i++) {
            Assert.assertEquals(hashAfterMining.charAt(i), '0');
        }
        String hashCalculatedInTest = StringUtil.applySha256(
                block.getPreviousHash() + block.getTimestamp() + block.getStringData() + block.getNonce()
        );
        Assert.assertEquals(hashCalculatedInTest, hashAfterMining);
    }
}
