package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {

        HashGen HsGen = new HashGen();
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

                    for (int i = 0; i < 1000; i++) {
                        HsGen.writeRainbowTables();
                    }
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








