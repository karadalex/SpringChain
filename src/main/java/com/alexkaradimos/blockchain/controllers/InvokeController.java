package com.alexkaradimos.blockchain.controllers;

import com.alexkaradimos.blockchain.models.Blockchain;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by karadalex on 14/4/2018.
 */
@RestController
public class InvokeController {

    /**
     * Add a new block with custom Data
     * @return
     */
    @RequestMapping(value = "/blocks/new", method = RequestMethod.POST)
    public String addNewBlock(@RequestBody String data) {
        Blockchain.addBlock(data);
        return "Block was successfully created on Blockchain";
    }

    /**
     * Add a new transaction
     * TODO
     * @return
     */
    @RequestMapping("/transaction/new")
    public String addNewTransaction() {
        return "success";
    }

    /**
     * Mine a block
     * TODO
     * @return
     */
    @RequestMapping("/block/mine")
    public String mineTransaction() {
        return "success";
    }
}
