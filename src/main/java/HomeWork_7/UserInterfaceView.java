package HomeWork_7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя города (на Русском языке): ");
            String city = scanner.nextLine();

            System.out.println("1 - покажет погоду сегодня; 5 - покажет погоду за 5 дней; 0 - выход");
            String command = scanner.nextLine();

            if (command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
