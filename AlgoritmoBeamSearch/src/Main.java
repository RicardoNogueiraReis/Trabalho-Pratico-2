/*
* [Trabalho Prático #2 - LEI SO] - 2022-2023
*
* Ricardo Reis - 202000806
* Diogo Silva  - 202000839
* */

import File.KnapTestsFileHandler;
import Objects.Bag;
import Objects.LowerBoundBag;

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

        LowerBoundBag lowerBound = new LowerBoundBag(bag);

        for (int i = 0; i < bag.items.length; i++) {
            // Verifica se a mochila não vai rebentar, se não rebentar
            // adiciona o item e adiciona-o, também, na solução que não rebenta com a mochila
            if(!lowerBound.isAboutToBurst(bag.items[i])){
                lowerBound.addItem(bag.items[i]);
                //System.out.println(lowerBound.items[i] + "\n");
            }

            // todo: Remover este código comentado
            // Adiciona o item e adiciona-o, também, na solução que não rebenta com a mochila
            /*lowerBound.addItem(bag.items[i]);

            //lowerBound.solution[i] = 1;

            if(lowerBound.checkIfOverweight()){
                lowerBound.removeLastItem(--i);
                break;
            }*/

        }

        System.out.println(lowerBound);
        System.out.println("=======\n"+lowerBound);

    }
}