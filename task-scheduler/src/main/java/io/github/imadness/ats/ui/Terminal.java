package io.github.imadness.ats.ui;

import io.github.imadness.ats.Application;
import io.github.imadness.ats.tasks.Task;
import io.github.imadness.ats.tasks.TaskManager;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static io.github.imadness.ats.ui.PrintUtils.*;

/**
 * Управление консолью
 */
public class Terminal {
    private static Scanner input = new Scanner(System.in);

    /**
     * Начинает взаимодействие программы с пользователем через консоль
     */
    public static void start() {
        TaskManager taskManager = Application.getTaskManager();
        displayTitle();
        displayStartMenu();
        String inputLine = "";
        while (!inputLine.equals("0")) {
            printInputIndicator();
            inputLine = input.nextLine();
            switch (inputLine) {
                case "1": {
                    List<Task> buffer = taskManager.getTaskBuffer();
                    for (int i = 0; i < buffer.size(); i++) {
                        displayTask(buffer.get(i), i + 1);
                    }
                    break;
                }
                case "2": {
                    printBlue("Введите название задачи:");
                    printInputIndicator();
                    String title = input.nextLine();
                    printBlue("Введите описание задачи:");
                    printInputIndicator();
                    String description = input.nextLine();
                    printBlue("Введите время оповещения в формате ДД/ММ/ГГГГ чч:мм (день, месяц, год, час, минута - соответственно)");
                    printInputIndicator();
                    Date notificationTime = null;
                    try {
                        notificationTime = Application.CONSOLE_DATE_FORMAT.parse(input.nextLine());
                    } catch (ParseException e) {
                        displayError("Ошибка: введённое время не соответствует заданному формату", e);
                        displayStartMenu();
                        break;
                    }

                    taskManager.addTask(new Task(title, description,notificationTime));
                    try {
                        taskManager.persistTasks();
                        printGreen("Задача [" + title + "] успешно добавлена");
                    } catch (IOException e) {
                        displayError("Не удалось сохранить список задач", e);
                    }
                    break;
                }
                case "3": {
                    List<Task> buffer = taskManager.getTaskBuffer();
                    if (buffer.isEmpty()) {
                        printBlue("Журнал задач пуст");
                        break;
                    } else {
                        printBlue("Введите номер задания, которое хотите удалить (1 - " + buffer.size() + ")");
                        printInputIndicator();
                        Integer taskNumber = null;
                        while (taskNumber == null || taskNumber <= 0 || taskNumber > buffer.size()) {
                            try {
                                taskNumber = Integer.parseInt(input.nextLine());
                            } catch (NumberFormatException e) {
                                printRed("Номер задания введён неверно. Попробуйте ещё раз");
                            }
                        }
                        taskNumber -= 1;
                        Task taskToRemove = buffer.get(taskNumber);
                        taskManager.removeTask(taskToRemove);
                        try {
                            taskManager.persistTasks();
                            printRed("Задача [" + taskToRemove.getName() + "] успешно удалена");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
                case "0": System.exit(0);
            }
        }

    }

    /**
     * Отображает меню действий
     */
    public static void displayStartMenu() {
        printYellow("1. Вывести список имеющихся заданий");
        printYellow("2. Добавить задание");
        printYellow("3. Удалить задание");
        printYellow("0. Завершить работу приложения");
        displaySeparator();
    }

    /**
     * Отображает указанную задачу
     * @param task задача для отображения
     */
    public static void displayTask(Task task) {
        printGreen(task.getName());
        print(task.getDescription());
        print("Запланировано на " + Application.CONSOLE_DATE_FORMAT.format(task.getNotificationTime().getTime()));
    }

    /**
     * Отображает задачу с определённым номером
     * @param task задача для вывода
     * @param number порядковый номер задачи в буфере
     */
    public static void displayTask(Task task, int number) {
        printGreen(number + ". " + task.getName());
        print(task.getDescription());
        print("Запланировано на " + Application.CONSOLE_DATE_FORMAT.format(task.getNotificationTime().getTime()));
        displaySmallSeparator();
    }

    /**
     * Отображает указанную задачу, при этом выводимые данные имеют специфическое оформление.
     * @param task задача для отображения
     */
    public static void displayTaskSevere(Task task) {
        printRed(task.getName());
        print(task.getDescription());
        printRed("Запланировано на " + Application.CONSOLE_DATE_FORMAT.format(task.getNotificationTime().getTime()));
        displaySmallSeparator();
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

    public static void displaySmallSeparator() {
        printBlue("------");
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
