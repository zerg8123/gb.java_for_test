package ru.geekbrains.lessons1;

public class Employee {
    String initial;
    String positions;
    String email;
    int telephoneNumber;
    int theSalary;
    int age;


    public Employee (String initial, String positions, String email, int telephoneNumber, int theSalary, int age) {
        this.initial = initial;
        this.positions = positions;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.theSalary = theSalary;
        this.age = age;
    }

    public Employee() {

    }

    public void info(){
        System.out.printf("Инициалы: %s; Должность: %s; email: %s; Номер телефона: %s; Зарплата: %s; Возраст: %s;%n", initial, positions, email, telephoneNumber, theSalary, age);
    }

    public Employee[] test() {
        Employee[] empArr = new Employee[5];

        empArr[0] = new Employee("Ivanov Ivan", "QA", "ivan@gmail.com", 88008008, 25000, 35);
        empArr[1] = new Employee("Stanislav Soda", "Enginer", "SodaEffect@ya.ru", 999999, 40000, 44);
        empArr[2] = new Employee("Nita Karaseva", "accountant", "NK@ya.ru", 79002514, 50000, 41);
        empArr[3] = new Employee("Artem Lobas", "Team lead", "LAbaby@gb.ru", 7982251, 55000, 50);
        empArr[4] = new Employee("Kekrill Kochanov", "Marketolog", "Kekdjan@ya.ru", 5458454, 55000, 31);

        return empArr;
    }
 }

