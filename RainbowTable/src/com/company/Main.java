package com.company;

import com.google.common.base.CharMatcher;
import com.google.common.hash.Hashing;
import java.util.Random;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;




public class Main {

    public static void main(String[] args) {

for (;;) {
    try {

        FileOutputStream fos = new FileOutputStream("tmp.xml");
        XMLEncoder e = new XMLEncoder(fos);
        e.writeObject(TableGenerator());
        e.close();


    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}

//
//            }


        }


        static String[] TableGenerator() throws FileNotFoundException {

            Random rand = new Random();


            Hashtable<String, String> numbers
                    = new Hashtable<String, String>();


            String StartingPlaintext= String.valueOf(rand.nextInt(900) + 001);
            String temp="0";
            int counter=0;
            String start="140";
            String end;
            String[] data = new String[10];
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
