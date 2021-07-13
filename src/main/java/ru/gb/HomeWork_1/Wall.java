package ru.gb.HomeWork_1;

public class Wall {
    private final int height;
    private final int number;

    public Wall(int height, int number) {
        this.height = height;
        this.number = number;
    }

    public int getHeight() {
        return height;
    }

    public int getNumber() {
        return number;
    }

    public int getTimeToOvercomeWall(CanJump jumper) {
        return jumper.jump(this);
    }
}
