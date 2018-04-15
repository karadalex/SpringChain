package com.alexkaradimos.blockchain;

import com.alexkaradimos.blockchain.models.Block;
import com.alexkaradimos.blockchain.models.Blockchain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by karadalex on 15/4/2018.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Blockchain.class})
@SpringBootTest
public class QueryByIndexTest {

    // TODO Test the API endpoint
    @Test
    public void queryByIndex() {
        new Blockchain();
        System.out.println("QueryByIndex Test");
        Blockchain.addBlock("block1");
        Blockchain.addBlock("block2");
        Blockchain.addBlock("block3");
        Block block2 = Blockchain.getBlocks().get(2);
        Assert.assertEquals(block2.getIndex(), 2);
        Assert.assertEquals(block2.getData(), "block2");
    }
}
