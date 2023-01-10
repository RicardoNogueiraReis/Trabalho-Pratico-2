package Objects;

import java.util.Arrays;

public class Bag {
    public int maxWeight;
    public Item[] items;
    public int currentValue;
    public int bestValue;
    public int currentWeight;
    public boolean isOverweight;

    public Bag(){ }


    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setBestValue(int bestValue) {
        this.bestValue = bestValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setOverweight(boolean overweight) {
        isOverweight = overweight;
    }

    public void setItems(Item[] items) {
        this.items = items;
        checkCurrentValue();
        checkCurrentWeight();
        //sortByValueWeightRatio();
        checkIfOverweight();
    }

    public boolean checkIfOverweight(){
        if(currentWeight > maxWeight)
            isOverweight = true;

        return isOverweight;
    }

    public int checkCurrentValue(){
        int newValue = 0;
        for(Item i: items)
            newValue += i.value;

        currentValue = newValue;

        return currentValue;
    }

    public int checkCurrentWeight(){
        int newWeight = 0;
        for(Item i: items)
            newWeight += i.weight;

        currentWeight = newWeight;
        return currentWeight;
    }

    public void sortByValueWeightRatio(){
        Arrays.sort(items, (o1, o2) ->
                    Double.compare(o1.value/ (double) o1.weight,
                                   o2.value / (double) o2.weight)
                );

        int itemLen = items.length;

        Item[] reversedItems = Arrays.copyOf(items, items.length);
        /*
        for (int i = 0; i < items.length; i++)
            reversedItems[i] = items[i];
        */

        int j = -1;
        for (int i = itemLen-1; i >= 0; i--)
            items[++j] = reversedItems[i];

    }

    @Override
    public String toString(){
        String p = "";

        for(Item i: items)
            p += i.value + " " + i.weight + "\n";

        return p;
    }
}
