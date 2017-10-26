package com.company;

import com.google.common.base.CharMatcher;
import com.google.common.hash.Hashing;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.Random;

public class HashGen {

    String[] TableGenerator() throws FileNotFoundException {

        Random rand = new Random();


        Hashtable<String, String> numbers
                = new Hashtable<String, String>();


        String StartingPlaintext= String.valueOf(rand.nextInt(900) + 100);
        String temp="0";
        String startEnd[]= new String[2];
        startEnd[0]=StartingPlaintext;
        for (int i=0; i<1000; i++) {

            temp = UnsaltedHash(StartingPlaintext);
            numbers.put(temp, StartingPlaintext);
            StartingPlaintext = reduceHash(temp);






        }

        startEnd[1]=temp;
        return startEnd;

    }

    static String reduceHash(String hash){



        String theDigits = CharMatcher.DIGIT.retainFrom(hash); // 123
        String reducedHash=theDigits.substring(0,3);



        //  UnsaltedHash(reducedHash);




        return reducedHash;


    }


    static String UnsaltedHash(String plaintext){


        String sha256hex = Hashing.md5()
                .hashString(plaintext, StandardCharsets.UTF_8)
                .toString();

        System.out.println(sha256hex);
        System.out.println(plaintext);
        System.out.println("\n");

        //SaltedHash(sha256hex,"asfd");
        //reduceHash(sha256hex);
        return sha256hex;
    }





}
