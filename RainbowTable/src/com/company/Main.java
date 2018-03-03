package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {

        CrackTrial CrTrial = new CrackTrial();
        Scanner scanner = new Scanner(System.in);

        Path currentRelativePath = Paths.get("");//I have this here until i fix the issue with file management between different systems(OSX,LINUX)
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        int userChoice = 0;
        boolean flag = true;
        while (flag == true) {
            System.out.println("Press 1 to crack md5 hashes\nPress 2 to generate rainbow tables\nPress 3 to exit");

            try {
                userChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n!!!PLEASE DON'T USE LETTERS");
                scanner.next();
            }







            switch (userChoice) {

                case 1: {


                    CrTrial.setCollisionsCounter(0);
                    CrTrial.check();

                    break;
                }

                case 2: {

                    int threads = Runtime.getRuntime().availableProcessors();
                    ExecutorService executor = Executors.newFixedThreadPool(threads);
                    System.out.println("Generation of RainbowTables has started, please wait........................");
                    Instant b = Instant.now();
                    for (int i = 0; i < 1000; i++) {
                        Runnable worker = new HashGen();
                        executor.execute(worker);
                    }

                    executor.shutdown();

                    while (!executor.isTerminated()) {
                                          };
                    Instant e = Instant.now();
                    System.out.println("Finished all threads");
                    Duration timeElapsed = Duration.between(b, e);
                    System.out.println("Generation completed. It took "
                            + (timeElapsed.toMillis())/1000.0+" Seconds");

                }
                break;

                case 3: {

                    flag = false;
                    break;
                }


                case 4: {//FOR PRESENTATION ONLY DONT USE IT

                    HashGen hs = new HashGen();
                    Instant b = Instant.now();
                    for (int i = 0; i < 1000; i++) {

                        hs.writeRainbowTables();
                    }
                    Instant e = Instant.now();
                    Duration timeElapsed = Duration.between(b, e);
                    System.out.println("elapsed time ( Milliseconds ):..."
                            + (timeElapsed.toMillis()));

                    break;
                }

                default:

                    System.out.println("Please choose only from the available options!!!\n");

                    break;


            }
        }

    }
}














