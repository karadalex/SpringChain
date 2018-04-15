package com.alexkaradimos.blockchain.controllers;

import com.alexkaradimos.blockchain.models.Block;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by karadalex on 14/4/2018.
 */
@RestController
public class QueryController {

    /**
     * Query Blockchain by Index
     * TODO
     * @param index
     * @return the block with the given index
     */
    @RequestMapping("/queryByIndex")
    public Block getBlockByIndex(@RequestParam(value="index", defaultValue = "1") int index) {
        return new Block(index, "timestamp", "previousHash", "data");
    }

}
