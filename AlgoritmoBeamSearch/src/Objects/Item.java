package Objects;

public class Item {
    public int value;
    public int weight;

    public Item() { }

    @Override
    public String toString(){
        return value + " " + weight;
    }

}
