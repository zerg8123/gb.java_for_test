package HomeWork_7.AcuuWeather;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - покажет погоду сегодня; 3 - покажет температуру с Яндекса; 5 - покажет погоду за 5 дней; 2 - полный вывод из БД; 0 - выход");
            String command = scanner.nextLine();
            String city = null;

            if (command.equals("1") || command.equals("5")) {
                System.out.println("Введите имя города (на Русском языке): ");
                city = scanner.nextLine();
            } else if (command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
