package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
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

        boolean flag = true;
        while (flag == true) {
            System.out.println("Press 1 to crack md5 hashes\nPress 2 to generate rainbow tables\nPress 3 to exit");
            int userChoice = scanner.nextInt();

            switch (userChoice) {

                case 1: {


                    CrTrial.setCollisionsCounter(0);
                    CrTrial.check();

                    break;
                }

                case 2: {

                    int threads = Runtime.getRuntime().availableProcessors();
                    ExecutorService executor = Executors.newFixedThreadPool(threads);

                    Instant b = Instant.now();
                    for (int i = 0; i < 1000; i++) {
                        Runnable worker = new HashGen();
                        executor.execute(worker);
                    }
                    executor.shutdown();

                    Instant e = Instant.now();
                    System.out.println("Finished all threads");
                    Duration timeElapsed = Duration.between(b, e);
                    System.out.println("elapsed time ( Seconds ):..."
                            + (timeElapsed.toMillis()));

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
                    System.out.println("elapsed time ( Millseconds ):..."
                            + (timeElapsed.toMillis()));

                    break;
                }

                default:

                    break;


            }
        }

    }
}








