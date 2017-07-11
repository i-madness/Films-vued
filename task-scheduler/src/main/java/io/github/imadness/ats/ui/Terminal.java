package io.github.imadness.ats.ui;

import java.util.Scanner;

import static io.github.imadness.ats.ui.PrintUtils.*;

/**
 * Управление консолью
 */
public class Terminal {
    private Scanner input = new Scanner(System.in);

    public Terminal() {
        displayTitle();
        displaySeparator();
        displayStartMenu();
        String inputLine = "";
        while (!inputLine.equals("0")) {
            inputLine = input.nextLine();
            print(inputLine);
        }
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
