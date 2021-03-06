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
public class GetAllBlocksTest {

    @Test
    public void getAll() {
        System.out.println("GetAll Test");
        new Blockchain();
        for (int i = 1; i <= 10; i++) {
            Blockchain.addBlock("block"+i);
        }
        Assert.assertEquals(Blockchain.getBlocks().size(), 11);
    }
}
