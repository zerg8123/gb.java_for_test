package HomeWork_3;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Apple apple = new Apple(1);
        Orange orange = new Orange(1);

    }

    public static void changeArrayElement(Object[] array, int a, int b) {
        Object tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
