package test;

public class Cat extends Animals{

    public Cat(String name, int lengthJump, int lengthSwim) {
        super(name, lengthJump, lengthSwim);
    }

    public Cat () {}

    public void run (int lengthRun) {
        if (lengthRun < 0 || lengthRun > 200) System.out.printf("ай не ври, кот не мог пробежать %sm%n", lengthRun);
        else System.out.printf("Котяра пробежал: %sm%n", lengthRun);
    }

    public void swim (int lengthSwim) {
        System.out.printf("Дискриминация котов, люди считают что коты не умеют плавать!!");
    }
}
