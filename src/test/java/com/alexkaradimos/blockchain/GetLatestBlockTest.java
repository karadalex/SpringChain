package com.alexkaradimos.blockchain;

import com.alexkaradimos.blockchain.models.Blockchain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by karadalex on 15/4/2018.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Blockchain.class})
@SpringBootTest
public class GetLatestBlockTest {

    @Test
    public void getLatest() {
        System.out.println("GetLatest Test");
        new Blockchain();
        System.out.println("QueryByIndex Test");
        for (int i = 1; i <= 10; i++) {
            Blockchain.addBlock("block"+i);
        }
        Assert.assertEquals(Blockchain.getLatestBlock().getStringData(), "block10");
        Assert.assertEquals(Blockchain.getLatestBlock().getIndex(), 10);
    }
}
