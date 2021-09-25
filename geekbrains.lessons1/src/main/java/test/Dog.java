package test;

public class Dog extends Animals{

    public Dog(String name, int lengthSwim, int lengthRun) {
        super(name, lengthSwim, lengthRun);
    }

    public Dog () {}

    public void run (int lengthRun) {
        if (lengthRun < 0 || lengthRun > 500) System.out.printf("ай не ври, собакен не мог пробежать %sm%n", lengthRun);
        else System.out.printf("Собакен пробежал: %sm%n", lengthRun);
    }

    public void swim (int lengthSwim) {
        if (lengthSwim < 0 || lengthSwim > 10) {
            System.out.printf("ну давай будем честными, собака не могла проплыть %sm%n", lengthSwim);
        } else {
        System.out.printf("Собака проплыла: %sm%n", lengthSwim);
        }
    }
}



