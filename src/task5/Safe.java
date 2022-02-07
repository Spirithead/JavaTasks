package task5;

import java.util.ArrayList;

public class Safe {
    private final ArrayList<Item> content;
    private int currWeight;
    private int currValue;

    public Safe(ArrayList<Item> content, int weight, int currValue){
        this.content = content;
        this.currValue = currValue;
        this.currWeight=weight;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder("content: ");
        String res;
        for(Item item: content){
            builder.append(item.toString()).append(" ");
        }
        builder.append("value: ").append(currValue);
        res = builder.toString();
        return res;
    }

    public int getCurrWeight() {
        return currWeight;
    }

    public int getCurrValue() {
        return currValue;
    }

    public void addItem(Item item){
        content.add(item);
        currWeight+=item.getWeight();
        currValue+=item.getValue();
    }

    public ArrayList<Item> getContent() {
        return new ArrayList<>(content);
    }
}
