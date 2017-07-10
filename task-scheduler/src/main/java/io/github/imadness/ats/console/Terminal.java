package io.github.imadness.ats.console;

import java.awt.*;
import java.net.URL;
import java.util.Scanner;

import static io.github.imadness.ats.console.PrintUtils.*;

/**
 * Управление консолью
 */
public class Terminal {
    private Scanner input = new Scanner(System.in);

    public Terminal() {
        try {
            displaySystemNotification();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        displayTitle();
        displaySeparator();
        displayStartMenu();
        String inputLine = "";
        while (!inputLine.equals("0")) {
            inputLine = input.nextLine();
            print(inputLine);
        }
    }

    // TODO not supposed to be here, but...
    public void displaySystemNotification() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        URL url = ClassLoader.getSystemResource("icon.png");
        Image image = Toolkit.getDefaultToolkit().createImage(url);
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
        trayIcon.displayMessage("Hello, World", "notification demo", TrayIcon.MessageType.WARNING);
    }

    public void displayStartMenu() {
        printYellow("1. Вывести список имеющихся заданий");
        printYellow("2. Добавить задание");
        printYellow("0. Завершить работу приложения");
    }

    public void displayTitle() {
        printGreen("╔═╗╔╦╗╔═╗ || Awesome");
        printGreen("╠═╣ ║ ╚═╗ || Task");
        printGreen("╩ ╩ ╩ ╚═╝ || Scheduler");
    }

    public void displaySeparator() {
        printBlue("\033[34m>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
