package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class CrackTrial {

    HashCracker HsCracker = new HashCracker();
    HashGen HsGen = new HashGen();
    private String hashToCrack;
    private ArrayList<String> hashesFromFile;
    private int collisionsCounter = 0;

    {
        hashesFromFile = new ArrayList<>();
    }

    public void setCollisionsCounter(int collisionsCounter) {
        this.collisionsCounter = collisionsCounter;
    }

    void check() throws IOException {

        HsCracker.readRainbowTable();
        System.out.println("Enter 1 to crack one hash value\nEnter 2 to crack multiple hash values from file");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();


        switch (userChoice) {

            case 1:
                String[] results;
                System.out.println("Give me a MD5 hash to crack....");
                Scanner scanner2 = new Scanner(System.in);
                hashToCrack = scanner2.nextLine();
                results = HsCracker.searchForHash(hashToCrack.toLowerCase());
                checkMultipleHashes(results);
                break;


            case 2:
                System.out.println("Loading results from crackMe.txt file");
                hashesFromFile = HsCracker.readHashesToCrack();

                for (int j = 0; j < hashesFromFile.size(); j++) {
                    hashToCrack = hashesFromFile.get(j);
                    results = HsCracker.searchForHash(hashToCrack.toLowerCase());
                    checkMultipleHashes(results);
                    if (collisionsCounter != 0) {

                        collisionsCounter = 0;
                    }

                }
                break;

            default:

                break;


        }
    }

    void checkMultipleHashes(String[] results) {

        if (results == null) {
            System.out.println("HASH NOT FOUND IN END OF AVAILABLE CHAINS");
            System.out.println("STARTED REVERSE TRAVERSING OF AVAILABLE RAINBOW-TABLES");
            System.out.println("........................................................");
            try {
                chainLookUp(hashToCrack);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("HASH FOUND IN END OF AVAILABLE CHAINS");

            System.out.println("Hash: "+results[1]+".....PlainText: "+HsGen.tableGenerator(results[0], results[1])[2]);
        }
    }

    void chainLookUp(String newGenaratedHash) throws FileNotFoundException {
        String tempHash = hashToCrack;
        String[] resultsOfChainSearch;
        String[] finalResults;

        for (; ; ) {
            String reducedHash = HsGen.reduceHash(newGenaratedHash);
            newGenaratedHash = HsGen.hashGenerator(reducedHash);
            resultsOfChainSearch = HsCracker.searchForHash(newGenaratedHash.toLowerCase());
            if (resultsOfChainSearch != null) {
                finalResults = HsGen.tableGenerator(resultsOfChainSearch[0], tempHash.toLowerCase());
                if (finalResults[2] != null && collisionsCounter < 1) {

                    System.out.println("Hash found in chain: \nStart of chain: " + resultsOfChainSearch[0] + "\nEnd of chain " + resultsOfChainSearch[1] + "\n" + "Original Hash: " + tempHash + ".....Plaintext:  " + finalResults[2] + "\n");
                    ++collisionsCounter;
                }

            }

            if (collisionsCounter >= 1) {

                break;
            } else {

                chainLookUp(newGenaratedHash);
            }
        }
    }
}






