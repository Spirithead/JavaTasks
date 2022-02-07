package task5;

public class Item {
    private final String name;
    private final int weight;
    private final int value;

    public Item(String name, int weight, int value){
        this.name=name;
        this.weight=weight;
        this.value=value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        String res;
        res=name+" "+weight+"kg";
        return  res;
    }
}
