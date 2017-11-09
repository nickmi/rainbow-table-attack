package com.company;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {

       // HashGen HsGen = new HashGen();
        CrackTrial CrTrial = new CrackTrial();
        HashCracker HsCracker = new HashCracker();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag == true) {
            System.out.println("Press 1 to crack md5 hashes\nPress 2 to generate rainbow tables\nPress 3 to exit");
            int userChoice = scanner.nextInt();

            switch (userChoice) {

                case 1: {

                    CrTrial.check();
                    break;
                }

                case 2: {
                    Instant b = Instant.now();
                    for (int i = 0; i < 1000; i++) {
                        HashGen HsGen = new HashGen();
                       HsGen.start();
                        //HsGen.writeRainbowTables();
                    }
                    Instant e = Instant.now();
                    Duration timeElapsed = Duration.between(b, e);
                    System.out.println("elapsed time ( Seconds ):..."
                            +(timeElapsed.toMillis()));
                }
                break;

                case 3: {

                    flag = false;
                    break;
                }

                default:

                    break;


            }
        }

    }
}








