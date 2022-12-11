/*
* [Trabalho Prático #2 - LEI SO] - 2022-2023
*
* Ricardo Reis - 202000806
* Diogo Silva  - 202000839
* */

import Objects.Bag;
import Objects.Item;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Parametrizável
        int MAX_WEIGHT = 11;
        int numberOfItems = 4;

        Item item1 = new Item(5,10);
        Item item2 = new Item(5,10);
        Item item3 = new Item(5,10);

        Bag bag = new Bag(MAX_WEIGHT);
        bag.addItem(item1);
        bag.addItem(item2);
        bag.addItem(item3);

        System.out.println(bag.isOverweight());
    }
}