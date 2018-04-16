package com.alexkaradimos.blockchain.controllers;

import com.alexkaradimos.blockchain.models.Blockchain;
import com.alexkaradimos.blockchain.models.SubBlock;
import com.alexkaradimos.blockchain.models.SubBlockchain;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by karadalex on 16/4/2018.
 */
@RestController
public class SubBlockchainController {

    /**
     * Add a new SubBlockchain with custom Data
     * @return
     */
    @RequestMapping(value = "/subBlockchains/new", method = RequestMethod.POST)
    public SubBlockchain addNewSubBlockchain(@RequestBody String data) {
        return Blockchain.addSubBlockchain(5);
    }

    /**
     * Add a new SubBlockchain with custom Data
     * @return
     */
    @RequestMapping(value = "/subBlockchains/getAll")
    public ArrayList<SubBlockchain> getAllSubBlockchains() {
        return Blockchain.getSubBlockchains();
    }

    /**
     * Add a new SubBlock to a specific Sub Blockchain
     * @param uuid
     * @param data
     * @return
     */
    @RequestMapping(value = "/subBlockchains/{uuid}/subBlocks/new", method = RequestMethod.POST)
    public SubBlock addNewSubBlock(@PathVariable("uuid") String uuid, @RequestBody String data) {
        int index = Blockchain.getSubBlockchainIndexFromUUID(uuid);
        SubBlockchain subBlockchain = Blockchain.getSubBlockchains().get(index);
        return subBlockchain.addSubBlock(data);
    }

    /**
     * Return all subBlocks from a specific SubBlockchain
     * @param uuid
     * @return
     */
    @RequestMapping(value = "/subBlockchains/{uuid}/getAll")
    public ArrayList<SubBlock> getSubBlochainAllSubBlocks(@PathVariable("uuid") String uuid) {
        int index = Blockchain.getSubBlockchainIndexFromUUID(uuid);
        SubBlockchain subBlockchain = Blockchain.getSubBlockchains().get(index);
        return subBlockchain.getSubBlocks();
    }
}
