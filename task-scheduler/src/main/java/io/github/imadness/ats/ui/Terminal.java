package io.github.imadness.ats.ui;

import java.util.Scanner;

import static io.github.imadness.ats.ui.PrintUtils.*;

/**
 * Управление консолью
 */
public class Terminal {
    private static Scanner input = new Scanner(System.in);

    public static void start() {
        displayTitle();
        displaySeparator();
        displayStartMenu();
        String inputLine = "";
        while (!inputLine.equals("0")) {
            inputLine = input.nextLine();
            print(inputLine);
        }
        System.exit(0);
    }

    /**
     * Отображает меню действий
     */
    public static void displayStartMenu() {
        printYellow("1. Вывести список имеющихся заданий");
        printYellow("2. Добавить задание");
        printYellow("0. Завершить работу приложения");
    }

    /**
     * Отображает название программы
     */
    public static void displayTitle() {
        printGreen("╔═╗╔╦╗╔═╗ || Awesome");
        printGreen("╠═╣ ║ ╚═╗ || Task");
        printGreen("╩ ╩ ╩ ╚═╝ || Scheduler");
    }

    /**
     * Отображает горизонтальный разделитель
     */
    public static void displaySeparator() {
        printBlue(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    /**
     * Отображает текст ошибки
     * @param text текст ошибки
     */
    public static void displayError(String text) {
        printRed(text);
    }

    /**
     * Отображает текст ошибки и соответствующее ей исключение
     * @param text текст ошибки
     * @param throwable исключение
     */
    public static void displayError(String text, Throwable throwable) {
        displayError(text + "\n" + throwable.toString());
    }
}
