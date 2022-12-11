package Objects;

import java.util.ArrayList;

public class Bag {
    private final int MAX_WEIGHT;
    private ArrayList<Item> ItemList;
    private int currentValue;
    private int currentWeight;
    private boolean isOverweight;

    public Bag(int MAX_WEIGHT, ArrayList<Item> ItemList){
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.ItemList = ItemList;
        countCurrentValueAndWeight();
    }

    public Bag(int MAX_WEIGHT) {
        this(MAX_WEIGHT, new ArrayList<>());
    }

    public void setItemList(ArrayList<Item> itemList) {
        if(itemList.isEmpty())
            return;

        ItemList = itemList;
        countCurrentValueAndWeight();
    }

    public void addItem(Item newItem) {
        if(newItem == null)
            return;

        ItemList.add(newItem);
        currentWeight += newItem.getWEIGHT();
        setIfOverweight();
    }

    /*  Muda o valor booleano isOverweight se o peso atual
     * passar do peso máximo da mochila.
     */
    private void setIfOverweight(){
        isOverweight = currentWeight > MAX_WEIGHT;
    }

    public ArrayList<Item> getItemList() { return ItemList; }

    public boolean isOverweight(){ return currentWeight > MAX_WEIGHT; }

    /*
    * Conta o valor e o peso total atual da mochila
    * */
    private void countCurrentValueAndWeight(){
        int v = 0;
        int w = 0;

        for(Item i: ItemList){
            v += i.getVALUE();
            w += i.getWEIGHT();
        }

        this.currentValue = v;
        this.currentWeight = w;
    }
}
