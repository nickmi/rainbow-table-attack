package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

 class CrackTrial {

    HashCracker HsCracker = new HashCracker();
    HashGen HsGen = new HashGen();
    String hashToCrack;
    private int collisionsCounter=0;

    void check()  {

        try {
            HsCracker.readRainbowTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Give me a MD5 hash to crack....");
        Scanner scanner = new Scanner(System.in);
        hashToCrack = scanner.nextLine();
        String[] results = HsCracker.searchForHash(hashToCrack.toLowerCase());

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

            try {
                HsGen.tableGenerator(results[0], results[1]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    void chainLookUp(String newGenaratedHash) throws FileNotFoundException {
        String tempHash = hashToCrack;
        String[] resultsOfChainSearch;
        String[] finalResults;

        for (;;) {
            String reducedHash = HsGen.reduceHash(newGenaratedHash);
            newGenaratedHash = HsGen.hashGenerator(reducedHash);
            resultsOfChainSearch = HsCracker.searchForHash(newGenaratedHash.toLowerCase());
            if (resultsOfChainSearch != null) {
                finalResults=HsGen.tableGenerator(resultsOfChainSearch[0], tempHash.toLowerCase());
                if (finalResults[2]!=null && collisionsCounter<1){

                 System.out.println("Hash found in chain: \nStart of chain: "+resultsOfChainSearch[0]+"\nEnd of chain "+resultsOfChainSearch[1]+"\n"+"Original Hash: "+tempHash+".....Plaintext:  "+finalResults[2]+"\n");
                 ++collisionsCounter;
            }

            }

            if (collisionsCounter>=1) {
                break;
           }
            else {

                chainLookUp(newGenaratedHash);
            }
        }

    }
}






