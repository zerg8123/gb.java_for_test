package ru.geekbrains.lessons1;

import java.util.Random;
import java.util.Scanner;

public class TicTacToc {

    public static char EMPTY_CELL_SYMBOL = '-';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static int ver, hor;

    public static void start () {
        char[][] field = {
                {EMPTY_CELL_SYMBOL, EMPTY_CELL_SYMBOL, EMPTY_CELL_SYMBOL},
                {EMPTY_CELL_SYMBOL, EMPTY_CELL_SYMBOL, EMPTY_CELL_SYMBOL},
                {EMPTY_CELL_SYMBOL, EMPTY_CELL_SYMBOL, EMPTY_CELL_SYMBOL}
        };

        drawField(field);
        do {
            doPlayerMove(field);
            drawField(field);

            if(isWin(field, 'X')) {
                System.out.println("Congratulation! You are winner!!");
            break;
            }
            if(isDraw(field)) {
                System.out.println("is draw");
                break;
            }

            doBotMove(field);
            drawField(field);
            if(isWin(field, 'O')) {
                System.out.println("Sorry, you are loser");
                break;
            }
            if(isDraw(field)) {
                System.out.println("is draw");
                break;
            }
        } while (true);
    }

    static boolean isDraw(char[][] field) {
        for (int ver = 0; ver < field.length; ver++) {
            for (int hor = 0; hor < field.length; hor++) {
                if(isEmptyCell(field)) return false;
            }
        }
        return true;
    }

    static boolean isWin(char[][] field, char sign) {
        //Horizon
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign) return true;
        }
        //Vertical
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == sign && field[1][i] == sign && field[2][1] == sign) return true;
        }
        if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign) return true;
        if (field[0][2] == sign && field[1][1] == sign && field[2][0] == sign) return true;
        return false;
    }
    static boolean isNotEmptyCell (char[][] field) {
        return !isEmptyCell(field);
    }

    static boolean isEmptyCell (char[][] field) {
        return field[ver][hor] != EMPTY_CELL_SYMBOL;
    }

    static void doBotMove(char[][] field){
        do {
            ver = random.nextInt(3);
            hor = random.nextInt(3);
        } while(isEmptyCell(field));
        field[ver][hor] = 'O';
    }

    static void doPlayerMove(char[][] field){
        do {
            ver = getCoordinate(field, 'v');
            hor = getCoordinate(field, 'h');
        } while(isEmptyCell(field));
        field[ver][hor] = 'X';
    }

    static int getCoordinate (char[][] field, char coordinateName) {
       int coordinate;
        do {
            System.out.printf("Please enter %s coordinate:%n", coordinateName);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= field.length);
    return coordinate;
    }

    static void drawField(char[][] field) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    System.out.print(field[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        System.out.println();
        }



}
