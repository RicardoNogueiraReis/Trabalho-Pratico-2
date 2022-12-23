package File;

import Objects.Bag;
import Objects.Item;

import java.io.*;
import java.util.Scanner;


public class KnapTestsFileHandler {


    public KnapTestsFileHandler() { }

    public static void readItemsFromFile(String fileName, Bag bag){

        try {

            File file = new File(fileName);

            BufferedReader reader = new BufferedReader(new FileReader(file));

            Item[] items;

            // Lê a primeira linha que indica o número de itens que vai estar na mochila
            int numberOfItems = Integer.parseInt(reader.readLine());

            // Array de Strings vai contar com o <número de itens> e o <peso total> da mochila
            // MAIS cada linha com os valores de cada item (2)
            // MAIS a melhor solução (3)
            items = new Item[numberOfItems];

            // Número de items
            //knap[0] = numberOfItems;

            // Peso total da mochila
            bag.setMaxWeight(Integer.parseInt(reader.readLine()));

            String line;

            for (int i = 0; (line = reader.readLine()) != null; i++) {
                String[] attributes = line.split(" ");

                if(attributes.length == 1){
                    bag.setBestValue(Integer.parseInt(attributes[0]));
                    break;
                }

                items[i] = new Item();

                items[i].value = Integer.parseInt(attributes[0]);
                items[i].weight = Integer.parseInt(attributes[1]);

            }

            reader.close();

            bag.setItems(items);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static int[] readItemsFromFileOLD2(String fileName){

        try {

            File file = new File(fileName);

            Scanner reader = new Scanner(file);

            int[] knap;

            // Lê a primeira linha que indica o número de itens que vai estar na mochila
            int numberOfItems = reader.nextInt();

            // Array de Strings vai contar com o <número de itens> e o <peso total> da mochila
            // MAIS cada linha com os valores de cada item (2)
            // MAIS a melhor solução (3)
            knap = new int[3 + numberOfItems];

            // Número de items
            knap[0] = numberOfItems;

            // Peso total da mochila
            knap[1] = reader.nextInt();

            for (int i = 2; i <= numberOfItems + 1; i++) {
                knap[i] = reader.nextInt();
            }

            knap[knap.length - 1] = reader.nextInt();

            reader.close();

            return knap;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String[] readItemsFromFileOLD(String fileName){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String[] knap;

            // Lê a primeira linha que indica o número de itens que vai estar na mochila
            int numberOfItems = Integer.parseInt(reader.readLine());

            // Array de Strings vai contar com o <número de itens> e o <peso total> da mochila
            // MAIS cada linha com os valores de cada item (2)
            // MAIS a melhor solução (3)
            knap = new String[3 + numberOfItems];

            // Número de items
            knap[0] = ""+numberOfItems;

            // Peso total da mochila
            knap[1] = reader.readLine();

            for (int i = 2; i <= numberOfItems + 1; i++) {
                knap[i] = reader.readLine();
            }

            knap[knap.length - 1] = reader.readLine();

            reader.close();

            return knap;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
