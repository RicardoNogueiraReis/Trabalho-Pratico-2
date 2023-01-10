package Objects;

import java.util.Arrays;

public class LowerBoundBag extends Bag{

    // Posição do primeiro item que não pode ser inserido na mochila por exceder o peso
    public int c;

    public int[] solution;

    public LowerBoundBag(Bag bag){
        int itemLen = bag.items.length;
        items = new Item[itemLen];

        solution = new int[itemLen];
        for (int i = 0; i < itemLen; i++)
            solution[i] = -1;

        maxWeight = bag.maxWeight;
        bestValue = bag.bestValue;
        currentValue = 0;
        currentWeight = 0;
        isOverweight = bag.isOverweight;

    }

    public void addItem(Item item) {

        for (int i = 0; i < items.length; i++) {
            if(items[i] == null){
                items[i] = item;
                solution[i] = 1;
                c++;
                break;
            }
        }

        currentValue += item.value;
        currentWeight += item.weight;
    }

    public boolean isAboutToBurst(Item addedItem){
        return currentWeight + addedItem.weight > maxWeight;
    }

    // todo: remover
    // Não tem em conta o solution
    @Deprecated
    @Override
    public void sortByValueWeightRatio(){
        int itemTempLen = c;

        Item[] itemTemp = Arrays.copyOf(items, itemTempLen);

        Arrays.sort(itemTemp, (o1, o2) ->
                Double.compare(o1.value/ (double) o1.weight,
                        o2.value / (double) o2.weight)
        );

        // Item[] itemsToReverse = Arrays.copyOf(items, itemTempLen);
        int j = -1;
        for (int i = itemTempLen - 1; i >= 0; i--)
            items[++j] = itemTemp[i];

    }


    /**
     * Utilizado para quando o último item inserido rebenta com a mochila.
     *
     * <p>@Deprecated porque o método isAboutToBurst() já verifica se vale a pena
     * inserir mais um item ou não, excusando o uso deste método que demora tempo
     * por iterar os itens até encontrar o último que não é nulo.</p>
     * @param lastItemIndex
     */
    @Deprecated
    public void removeLastItem(int lastItemIndex){
        for(int i = lastItemIndex; i < solution.length; i++)
            solution[i] = 0;

        c = lastItemIndex - 1;
    }

    @Override
    public String toString(){
        String p = "";

        for (int i = 0; i < solution.length; i++)
            p += solution[i] + " " + items[i] + "\n";

        return p;
    }

}
