package ru.gb.HomeWork_1;

public class Main {
    public static void main(String[] args) {
        Cat[] cat = {new Cat("barsick", 15, 10), new Cat("sneshock", 10, 5), new Cat("garfield", 25, 20)};
        People[] people = {new People("Jora", 15, 10), new People("Kekrill", 10, 5), new People("Roma", 25, 20)};
        Robot[] robot = {new Robot("b234", 15, 10), new Robot("r1d3", 10, 5), new Robot("pobeda", 25, 20)};
        TreadMill[] treadMills = {new TreadMill(10, 1), new TreadMill(15, 2), new TreadMill(25, 3)};
        Wall[] walls = {new Wall(10, 1), new Wall(5, 2), new Wall(4, 3)};

        for (Wall wall : walls) {
            System.out.printf("Стена номер %s%n", wall.getNumber());
            for (int i = 0; i < walls.length; i++) {
                wall.getTimeToOvercomeWall(cat[i]);
                wall.getTimeToOvercomeWall(people[i]);
                wall.getTimeToOvercomeWall(robot[i]);
            }
            System.out.println(" ");
        }

        for (TreadMill treadMill : treadMills) {
            System.out.printf("Дорожка номер %s%n", treadMill.getNumber());
            for (int i = 0; i < treadMills.length; i++) {
                treadMill.getTimeToOvercomeTreadMill(cat[i]);
                treadMill.getTimeToOvercomeTreadMill(people[i]);
                treadMill.getTimeToOvercomeTreadMill(robot[i]);
            }
            System.out.println(" ");
        }
    }
}
