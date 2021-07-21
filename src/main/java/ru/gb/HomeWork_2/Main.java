package ru.gb.HomeWork_2;

public class Main {
    public static int DoubleArrayLengthHeight = 4;  //для быстрой настройки Высоты
    public static int DoubleArrayLengthWidth = 4;   //для быстрой настройки Ширины
    public static int SumDoubleArrayInteger = 0;

    public static void main(String[] args) {
        String[][] successArray =
                {{"1", "10", "1331", "0"},
                        {"1", "10", "1331", "0"},
                        {"1", "10", "1331", "0"},
                        {"1", "10", "1331", "0"}};


        String[][] notSuccessArrayString =
                {{"1", "10", "1331", "0"},
                        {"1", "привет", "1331", "0"},
                        {"1", "10", "1331", "0"},
                        {"1", "10", "1331", "0"}};


        String[][] notSuccessArraySymbol =
                {{"1", "10", "1331", "0"},
                        {"1", "/", "1331", "0"},
                        {"1", "10", "1", "0"},
                        {"1", "10", "1331", "0"}};

        System.out.println(arraySum(successArray));
        System.out.println(arraySum(notSuccessArrayString));
        System.out.println(arraySum(notSuccessArraySymbol));
    }

    public static int arraySum(String[][] DoubleArray) {
        if (DoubleArray.length != DoubleArrayLengthWidth) throw new MyArraySizeException("Длинна только 4!");

        for (String[] arr : DoubleArray) {
            if (arr.length != DoubleArrayLengthHeight) throw new MyArraySizeException("Высота только 4!");
        }

        for (int i = 0; i < DoubleArray.length; i++) {
            for (int j = 0; j < DoubleArray[i].length; j++) {
                try {
                    SumDoubleArrayInteger += Integer.parseInt(DoubleArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ты мне втираешь что в поле: " + i + "," + j + "Число??");
                }
            }
        }
        return SumDoubleArrayInteger;
    }
}
