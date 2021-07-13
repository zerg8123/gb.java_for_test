package ru.gb.HomeWork_1;

public class TreadMill {
    private final int lenght;
    private final int number;

    public TreadMill(int lenght, int number) {
        this.lenght = lenght;
        this.number = number;
    }

    public int getLenght() {
        return lenght;
    }

    public int getNumber() {
        return number;
    }

    public int getTimeToOvercomeTreadMill(CanRun runner) {
        return runner.run(this);
    }
}
