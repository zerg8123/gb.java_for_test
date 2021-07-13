package ru.gb.HomeWork_1;

public class Cat implements CanJump, CanRun {
    private int runSpeed;
    private int jumpHeight;
    private String name;

    public Cat(String name, int runSpeed, int jumpHeight) {
        this.name = name;
        if (runSpeed >= 15) {
            this.runSpeed = runSpeed;
        } else {
            System.out.printf("Ай не ври, %s не мог столько пробежать%n", name);
        }
        if (jumpHeight >= 10) {
            this.jumpHeight = jumpHeight;
        } else {
            System.out.printf("%s не мог столько проплыть%n", name);
        }
    }

    public int run(TreadMill treadMill) {
        if (runSpeed >= treadMill.getLenght()) {
            System.out.printf("%s бежит медленее чем скорость дорожки, поэтому он упал на дорожке: %s%n", name, treadMill.getNumber());
        } else {
            System.out.printf("%s пробежал нужное количество на дорожке: %s%n", name, treadMill.getNumber());
        }
        return treadMill.getLenght();
    }

    public int jump(Wall wall) {
        if (jumpHeight <= wall.getHeight()) {
            System.out.printf("%s недопрыгнул и врезался в стену %s%n", name, wall.getNumber());
        } else {
            System.out.printf("%s перепрыгнул стену номер: %s%n", name, wall.getNumber());
        }
        return wall.getHeight();
    }
}
