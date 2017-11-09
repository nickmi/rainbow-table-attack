package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class HashCracker {

    private String results[] = new String[2];
    private Map<String, String> map = new HashMap<>();


    void readRainbowTable() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("/home/nickdev/Desktop/testing2.txt"));
        String line;
        while ((line = in.readLine()) != null) {
            String parts[] = line.split("  ");
            map.put(parts[1], parts[0]);
        }
        in.close();
        System.out.println();
    }


    ArrayList readHashesToCrack() throws IOException {

        ArrayList<String> hashesFromFile = new ArrayList<>();

        BufferedReader in = new BufferedReader(new FileReader("crackMe.txt"));
        String line;
        while ((line = in.readLine()) != null) {
            String parts = line;
            hashesFromFile.add(parts);
        }
        in.close();
        return hashesFromFile;
    }


    String[] searchForHash(String givenHashFromUser) {


        if (map.containsKey(givenHashFromUser)) {

            String plainTextValue = map.get(givenHashFromUser);
            results[0] = plainTextValue;
            results[1] = givenHashFromUser;

            return results;
        } else {
            return null;
        }
    }
}