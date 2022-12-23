/*
* [Trabalho Prático #2 - LEI SO] - 2022-2023
*
* Ricardo Reis - 202000806
* Diogo Silva  - 202000839
* */

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

import java.io.IOException;
import java.io.FileNotFoundException;

import File.KnapTestsFileHandler;
import Objects.Bag;
import Objects.Item;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Bag bag = new Bag();

        KnapTestsFileHandler.readItemsFromFile("knap_tests_extended\\ex05.txt", bag);

        /*
        long start = System.currentTimeMillis();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
        // */


        System.out.println(bag);
        System.out.println("»»»");
        bag.sortValueWeightRatio();
        System.out.println(bag);


    }
}