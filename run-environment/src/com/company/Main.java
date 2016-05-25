package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        CommandExecutor executor = new CommandExecutor();

        while (executor.isReading()) {
            try {
                String line = bfr.readLine();

                executor.parseInput(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(executor.getResult());
    }
}
