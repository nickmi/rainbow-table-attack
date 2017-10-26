package com.company;

import com.google.common.base.CharMatcher;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Hashtable;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

public class Main {

    public static void main(String[] args) {
        Hashtable<String, String> numbers
                = new Hashtable<String, String>();


        String StartingPlaintext="123";
        String temp ;
        for (int i=0; i<=165668499; i++) {

           temp= UnsaltedHash(StartingPlaintext);
            numbers.put(temp,StartingPlaintext);
           StartingPlaintext= reduceHash(temp);







        }



        System.out.println("TEST :");
        System.out.println(numbers.get("202cb962ac59075b964b07152d234b70"));


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


    static String reduceHash(String hash){



        String theDigits = CharMatcher.DIGIT.retainFrom(hash); // 123
        String reducedHash=theDigits.substring(0,3);



      //  UnsaltedHash(reducedHash);




            return reducedHash;


    }





    static void SaltedHash(String hash, String salt){


        String sha256hexSalt = Hashing.sha256()
                .hashString(salt, StandardCharsets.UTF_8)
                .toString();

        System.out.println(hash+sha256hexSalt);





    }




}
