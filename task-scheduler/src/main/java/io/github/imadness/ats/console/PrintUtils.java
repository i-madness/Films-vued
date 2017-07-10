package io.github.imadness.ats.console;

/**
 * Декорационные методы для печати
 */
public class PrintUtils {
    public static void print(String text) {
        System.out.println("\033[38m" + text);
    }

    public static void printGreen(String text) {
        System.out.println("\033[32m" + text);
    }

    public static void printYellow(String text) {
        System.out.println("\033[33m" + text);
    }

    public static void printBlue(String text) {
        System.out.println("\033[34m" + text);
    }
}
