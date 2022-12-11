package Objects;

public class Item {
    private final int VALUE;
    private final int WEIGHT;

    public Item(int VALUE, int WEIGHT) {
        this.VALUE = VALUE;
        this.WEIGHT = WEIGHT;
    }

    public int getVALUE() { return VALUE; }

    public int getWEIGHT() { return WEIGHT; }
}
