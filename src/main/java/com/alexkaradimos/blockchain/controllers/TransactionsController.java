package com.alexkaradimos.blockchain.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by karadalex on 14/4/2018.
 */
@RestController
public class TransactionsController {

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
     * Mine a transaction
     * TODO
     * @return
     */
    @RequestMapping("/transaction/mine")
    public String mineTransaction() {
        return "success";
    }
}
