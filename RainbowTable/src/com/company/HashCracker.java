package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashCracker {

    private static final String[] NO_FILES = {};
    private String results[] = new String[2];
    private Map<String, String> map = new HashMap<String, String>();


    public void readRainbowTable() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("testing.txt"));
        String line = "";
        while ((line = in.readLine()) != null) {
            String parts[] = line.split("  ");
            map.put(parts[1], parts[0]);
        }
        in.close();
        System.out.println();
    }


    public String[] SearchForHash(String GiveMeAhashBro) {


        if (map.containsKey(GiveMeAhashBro)) {
            String plaintextValue = map.get(GiveMeAhashBro);
            results[0] = plaintextValue;
            results[1] = GiveMeAhashBro;
            System.out.println("HASH FOUND IN END OF CHAIN \nSTARTING PLAINTEXT OF CHAIN: " + plaintextValue);
            System.out.println("GENERATING TABLE.......");
            return results;
        } else {
            return null;

        }
    }
}