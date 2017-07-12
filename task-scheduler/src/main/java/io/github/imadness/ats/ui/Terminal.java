package io.github.imadness.ats.ui;

import io.github.imadness.ats.Application;
import io.github.imadness.ats.tasks.Task;
import io.github.imadness.ats.tasks.TaskManager;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import static io.github.imadness.ats.ui.PrintUtils.*;

/**
 * Управление консолью
 */
public class Terminal {
    private static Scanner input = new Scanner(System.in);

    public static void start() {
        displayTitle();
        displayStartMenu();
        String inputLine = "";
        while (!inputLine.equals("0")) {
            System.out.print("> ");
            inputLine = input.nextLine();
            switch (inputLine) {
                case "1": {
                    System.out.println("nothing here");
                    //inputLine = null;
                    break;
                }
                case "2": {
                    printBlue("Введите название задачи:");
                    System.out.print("> ");
                    String title = input.nextLine();
                    printBlue("Введите описание задачи:");
                    System.out.print("> ");
                    String description = input.nextLine();
                    printBlue("Введите время оповещения в формате ДД/ММ/ГГГГ чч/мм (день, месяц, год, час, минута - соответственно)");
                    System.out.print("> ");
                    Date notificationTime = null;
                    try {
                        notificationTime = Application.CONSOLE_DATE_FORMAT.parse(input.nextLine());
                    } catch (ParseException e) {
                        displayError("Ошибка: введённое время не соответствует заданному формату", e);
                        displayStartMenu();
                        break;
                    }
                    TaskManager taskManager = Application.getTaskManager();
                    taskManager.addTask(new Task(title, description,notificationTime));
                    try {
                        taskManager.persistTasks();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //inputLine = null;

                    break;
                }
                case "0": System.exit(0);
            }
            print(inputLine);
        }

    }

    /**
     * Отображает меню действий
     */
    public static void displayStartMenu() {
        printYellow("1. Вывести список имеющихся заданий");
        printYellow("2. Добавить задание");
        printYellow("0. Завершить работу приложения");
        displaySeparator();
    }

    /**
     * Отображает название программы
     */
    public static void displayTitle() {
        printGreen("╔═╗╔╦╗╔═╗ || Awesome");
        printGreen("╠═╣ ║ ╚═╗ || Task");
        printGreen("╩ ╩ ╩ ╚═╝ || Scheduler");
        displaySeparator();
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
