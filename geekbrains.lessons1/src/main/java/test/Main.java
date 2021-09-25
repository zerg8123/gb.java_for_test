package test;

public class Main {
    public static void main(String[] args) {
        Animals animals = new Animals();
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.run(150);
        dog.run(550);
        dog.run(-250);
        dog.swim(250);
        dog.swim(5);
        dog.swim(-5);

        cat.run(100);
        cat.run(250);
        cat.run(-250);
        cat.swim(500);

    }

}
