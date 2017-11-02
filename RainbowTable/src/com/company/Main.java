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

    HashGen HsGen= new HashGen();
    CrackTrial CrTrial = new CrackTrial();
    HashCracker HsCracker = new HashCracker();

        CrTrial.check();


       // System.out.println(HsCracker.readHashesToCrack().get(1));

//
//for(int i=0;i<1000;i++) {
 //   HsGen.writeRainbowTables();
//}
//
//






}}








