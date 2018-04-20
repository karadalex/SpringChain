package com.alexkaradimos.blockchain.helpers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by karadalex on 20/4/2018.
 */
public class Storage {

    public static void serializeBlockchain() {
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

    public static void deserializeBlockchain() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            BlockchainData data = objectMapper.
                    readValue(new File("target/data.json"), BlockchainData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
