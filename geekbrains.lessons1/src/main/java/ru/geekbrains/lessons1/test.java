package ru.geekbrains.lessons1;
import java.util.Random;
import java.util.Scanner;

public class test {

    public class Main {
        public static void main(String[] args) {
            doVarargsDemo();
            doVarargsDemo(new int[] {9});
            doVarargsDemo(1);
            doVarargsDemo(1, 2);
            doVarargsDemo(1, 2, 3);
        }

        static void doVarargsDemo(int... numbers) {
            System.out.println("SIZE: " + numbers.length);
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i]);
                System.out.print(" ");
            }
            System.out.println();
        }

        static void doRandomDoubleValuesDemo() {
            double[] doubles = fillDoubleArrayRandomly(100);
            printArray(doubles, "[%d] => %.3f %n");
        }

        static void doRandomValuesDemo() {
            int[] ints = fillArrayRandomly(5000);
            printArray(ints);
        }

        static void printArray(int[] numbers) {
            for (int i = 0; i < numbers.length; i++) {
                String format = String.format("[%s] => %s%n", i, numbers[i]);
                System.out.print(format);
            }
        }

        static void printArray(int[] numbers, String template, boolean reverse) {
            for (int i = 0; i < numbers.length; i++) {
                System.out.printf(template, i, numbers[i]);
            }
        }

        static void printArray(String template, double[] numbers) {
            for (int i = 0; i < numbers.length; i++) {
                System.out.printf(template, i, numbers[i]);
            }
        }

        static void printArray(double[] numbers, String template) {
            for (int i = 0; i < numbers.length; i++) {
                System.out.printf(template, i, numbers[i]);
            }
        }

        static void printArray(double[] numbers) {
            for (int i = 0; i < numbers.length; i++) {
                System.out.printf("[%s] => %s%n", i, numbers[i]);
            }
        }

        static double[] fillDoubleArrayRandomly(int size) {
            double[] numbers = new double[size];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Math.random();
            }

            return numbers;
        }

        static int[] fillArrayRandomly(int size) {
            int[] numbers = new int[size];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = generateRandom(-5, 5);
            }

            return numbers;
        }

        static int generateRandom(int min, int max) {
//        Math.random(); vs new Random().nextDouble()
            Random random = new Random();
            return random.nextInt(max - min) + min;
        }

        /**
         * Range: [0, N) or from 0 to N-1
         */
        static int generateRandom(int bound) {
            Random random = new Random();
            return random.nextInt(bound);
        }

        static int generateRandom() {
            Random random = new Random();
            return random.nextInt();
        }

        static int[] fillArrayManually(int size) {
            int[] numbers = new int[size];

            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = scanner.nextInt();
            }

            return numbers;
        }

        static void doScannerDemo() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter name ...");
            String name = scan.nextLine();
            System.out.println("Your name: " + name);

            System.out.println("Please enter age ...");
//        int age = Integer.parseInt(scan.nextLine());
            int age = scan.nextInt();
            System.out.println("Your age: " + age);
        }
    }
}
