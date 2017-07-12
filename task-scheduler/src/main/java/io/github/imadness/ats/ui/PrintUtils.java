package io.github.imadness.ats.ui;

/**
 * Декорационные методы для печати
 */
public class PrintUtils {
    /**
     * Вывод сообщения в консоль стандартным цветом
     * @param text текст сообщения
     */
    public static void print(String text) {
        System.out.println("\033[38m" + text);
    }

    /**
     * Выводит в консоль индикатор пользовательского ввода (означает, что пользователь может вводить команды)
     */
    public static void printInputIndicator() {
        System.out.print("\033[38m> ");
    }

    /**
     * Выводит сообщения в консоль красным цветом
     * @param text текст сообщения
     */
    public static void printRed(String text) {
        System.out.println("\033[31m" + text);
    }

    /**
     * Вывод сообщения в консоль зелёным цветом
     * @param text текст сообщения
     */
    public static void printGreen(String text) {
        System.out.println("\033[32m" + text);
    }

    /**
     * Вывод сообщения в консоль жёлтым цветом
     * @param text текст сообщения
     */
    public static void printYellow(String text) {
        System.out.println("\033[33m" + text);
    }

    /**
     * Вывод сообщения в консоль голубым цветом
     * @param text текст сообщения
     */
    public static void printBlue(String text) {
        System.out.println("\033[34m" + text);
    }
}
