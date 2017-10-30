package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CrackTrial {

    HashCracker hscracker = new HashCracker();
    HashGen hsgen = new HashGen();
    String HashToCrack;

    void check() throws IOException {

        hscracker.readRainbowTable();
        System.out.println("Give me a MD5 hash to crack....");
        Scanner scanner = new Scanner(System.in);
        HashToCrack = scanner.nextLine();
        String[] results = hscracker.SearchForHash(HashToCrack.toLowerCase());

        if (results == null) {
            System.out.println("HASH NOT FOUND IN END OF AVAILABLE CHAINS");
            System.out.println("STARTED REVERSE TRAVERSING OF AVAILABLE RAINBOW-TABLES");
            System.out.println("........................................................");
            ChainLookUp(HashToCrack);

        } else {

            hsgen.TableGenerator(results[0], results[1]);
        }
    }


    void ChainLookUp(String NewGenaratedHash) throws FileNotFoundException {
        String tempHash = HashToCrack;
        String[] results2 = new String[0];
        for (; ; ) {
            String reducedHash = hsgen.reduceHash(NewGenaratedHash);
            NewGenaratedHash = hsgen.UnsaltedHash(reducedHash);
            results2 = hscracker.SearchForHash(NewGenaratedHash.toLowerCase());
            if (results2 != null) {
                System.out.println(hsgen.TableGenerator(results2[0], tempHash.toLowerCase()));
                break;
            }
            ChainLookUp(NewGenaratedHash);
        }

    }
}






