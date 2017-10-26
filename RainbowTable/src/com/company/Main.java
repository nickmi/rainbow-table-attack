package com.company;

import com.google.common.base.CharMatcher;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {



            UnsaltedHash("123");

    }


    static void UnsaltedHash(String plaintext){


        String sha256hex = Hashing.md5()
                .hashString(plaintext, StandardCharsets.UTF_8)
                .toString();
        System.out.println(plaintext);
        System.out.println(sha256hex);
        System.out.println("\n");

        //SaltedHash(sha256hex,"asfd");
        reduceHash(sha256hex);

    }


    static void reduceHash(String hash){

        Hashtable<String, String> numbers
                = new Hashtable<String, String>();


        String theDigits = CharMatcher.DIGIT.retainFrom(hash); // 123
        String reducedHash=theDigits.substring(0,3);



        UnsaltedHash(reducedHash);







    }





    static void SaltedHash(String hash, String salt){


        String sha256hexSalt = Hashing.sha256()
                .hashString(salt, StandardCharsets.UTF_8)
                .toString();

        System.out.println(hash+sha256hexSalt);





    }




}
