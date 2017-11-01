package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

 class HashCracker {

    private String results[] = new String[2];
    private Map<String, String> map = new HashMap<>();


     void readRainbowTable() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("testing2.txt"));
        String line;
        while ((line = in.readLine()) != null) {
            String parts[] = line.split("  ");
            map.put(parts[1], parts[0]);
        }
        in.close();
        System.out.println();
    }

     String[] searchForHash(String givenHashFromUser) {


        if (map.containsKey(givenHashFromUser)) {

            String plaintextValue = map.get(givenHashFromUser);
            results[0] = plaintextValue;
            results[1] = givenHashFromUser;

            return results;
        } else {
            return null;
        }
    }
}