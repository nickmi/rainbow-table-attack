package com.company;

import com.google.common.base.CharMatcher;
import com.google.common.hash.Hashing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;




public class Main {

    public static void main(String[] args) throws FileNotFoundException {
;
for (int i =0; i<1000;i++) {
    HashGen hg = new HashGen();

    String data[]  = hg.TableGenerator();
    Path path = Paths.get("testing.txt");
    Charset charset = Charset.forName("UTF-8");
    try {
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset, StandardOpenOption.APPEND)) {
            writer.write("  "+data[0] + "  " + data[1]  );
            writer.newLine();

        }
    } catch (IOException e) {
        e.printStackTrace();
    }


}
}}
