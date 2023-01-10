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
            // MAIS o valor ótimo (3)
            items = new Item[numberOfItems];

            // Número de items
            //knap[0] = numberOfItems;

            // Peso total da mochila
            bag.setMaxWeight(Integer.parseInt(reader.readLine()));

            // (2)
            String line;
            for (int i = 0; (line = reader.readLine()) != null; i++) {
                String[] attributes = line.split(" ");

                // (3)
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

}
