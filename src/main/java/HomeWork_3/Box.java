package HomeWork_3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList = new ArrayList();

    public Box() {
    }

    public ArrayList<T> getFruitList() {
        return this.fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public void addFruit(T fruit) {
        this.fruitList.add(fruit);
    }

    public String toString() {
        return "Box{fruitList=" + this.fruitList + "}";
    }

    public float getWeight() {
        return (float) this.fruitList.size() * ((Fruit) this.fruitList.get(0)).getWeight();
    }

    public boolean isSameAvg(Box<?> boxToCompare) {
        return (double) Math.abs(this.getWeight() - boxToCompare.getWeight()) > 1.0E-4D;
    }

    public void pour(Box<T> box) {
        box.getFruitList().addAll(this.fruitList);
        this.fruitList.clear();
    }
}
