package com.alexkaradimos.blockchain.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by karadalex on 20/4/2018.
 */
public class Storage {

    public static void backupBlockchain() {
        BlockchainData data = new BlockchainData();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File("target/data.json"), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
