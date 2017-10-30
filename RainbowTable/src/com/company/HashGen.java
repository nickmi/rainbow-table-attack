package com.company;

import com.google.common.base.CharMatcher;
import com.google.common.hash.Hashing;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Random;

public class HashGen {


    Hashtable<String, String> numbers
            = new Hashtable<String, String>();

    Random rand = new SecureRandom();

    String[] TableGenerator() throws FileNotFoundException {

        int number = rand.nextInt(999);
        String StartingPlaintext = String.valueOf(number);
        String temp = "0";
        String startEnd[] = new String[2];
        startEnd[0] = StartingPlaintext;
        for (int i = 0; i < 10000; i++) {

            temp = UnsaltedHash(StartingPlaintext);
            numbers.put(temp, StartingPlaintext);
            StartingPlaintext = reduceHash(temp);

        }
        startEnd[1] = temp;
        return startEnd;
    }

    String[] TableGenerator(String StartingPlaintext, String HashtoCheck) throws FileNotFoundException {

        String temp = "0";
        String startEnd[] = new String[3];
        startEnd[0] = StartingPlaintext;
        for (int i = 0; i < 10000; i++) {

            temp = UnsaltedHash(StartingPlaintext);
            numbers.put(temp, StartingPlaintext);
            StartingPlaintext = reduceHash(temp);


        }
        System.out.println("HASH VALUE: " + HashtoCheck + " .............. PLAINTEXT: " + numbers.get(HashtoCheck));
        System.out.println();
       // startEnd[2] = numbers.get(HashtoCheck.toString());
        startEnd[1] = temp;
        return startEnd;

    }

    String reduceHash(String hash) {

        Random rand = new Random();
        int number2 = rand.nextInt(8);

        String theDigits = CharMatcher.DIGIT.retainFrom(hash); // 123
        String reducedHash = theDigits.substring(number2);
        String reducedHash2 = reducedHash.substring(0, 3);
        return reducedHash2;

    }

    String UnsaltedHash(String plaintext) {


        String md5hex = Hashing.md5()
                .hashString(plaintext, StandardCharsets.UTF_8)
                .toString();

        return md5hex;
    }


    void WriteRainbowTables() throws FileNotFoundException {

        String data[] = TableGenerator();
        Path path = Paths.get("testing.txt");
        Charset charset = Charset.forName("UTF-8");
        try {
            try (BufferedWriter writer = Files.newBufferedWriter(path, charset, StandardOpenOption.APPEND)) {
                writer.write(data[0] + "  " + data[1]);
                writer.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}






