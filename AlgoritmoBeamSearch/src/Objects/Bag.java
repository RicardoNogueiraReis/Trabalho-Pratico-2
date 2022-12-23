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

    public void setItems(Item[] items) {
        this.items = items;
        checkCurrentValue();
        checkCurrentWeight();
        checkIfOverweight();
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

    private void checkIfOverweight(){
        if(currentWeight > maxWeight)
            isOverweight = true;
    }

    public void checkCurrentValue(){
        int newValue = 0;
        for(Item i: items)
            newValue += i.value;
    }

    public void checkCurrentWeight(){
        int newWeight = 0;
        for(Item i: items)
            newWeight += i.weight;
    }

    public void sortValueWeightRatio(){
        Arrays.sort(items, (o1, o2) ->
                    Double.compare(o1.value/ (double) o1.weight,
                                   o2.value / (double) o2.weight)
                );
    }

    @Override
    public String toString(){
        String p = "";

        for(Item i: items)
            p += i.value + " " + i.weight + "\n";

        return p;
    }
}
