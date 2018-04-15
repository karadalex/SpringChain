package com.alexkaradimos.blockchain.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by karadalex on 14/4/2018.
 */
@RestController
public class NodesController {

    /**
     * Accept a list of new nodes in the form of URLs
     * TODO
     * @return
     */
    @RequestMapping("/nodes/register")
    public String registerNodes() {
        return "Success";
    }

    /**
     * Resolves any conflicts—to ensure a node has the correct chain
     * TODO
     * @return
     */
    @RequestMapping("/nodes/resolve")
    public String resolveNode() {
        return "Success";
    }
}
