package test;

public class Animals {
    private String name;
    private int lengthRun;
    private int lengthSwim;
    private int animalsNumber = 0;

    public Animals (String name, int lengthJump, int lengthRun) {
        this.name = name;
        this.lengthRun = lengthRun;
        this.lengthSwim = lengthJump;
    }

    public Animals (int animalsNumber) {
        this.animalsNumber = animalsNumber;
    }
    public Animals() {
        animalsNumber++;
    }

    public int getAnimalsNumber() {
        return animalsNumber;
    }

    public String getName() {
        return name;
    }

    public int getLengthRun() {
        return lengthRun;
    }

    public int getLengthSwim() {
        return lengthSwim;
    }
}
