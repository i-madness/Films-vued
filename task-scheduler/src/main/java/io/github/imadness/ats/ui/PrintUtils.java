package io.github.imadness.ats.ui;

import io.github.imadness.ats.Application;

/**
 * Декорационные методы для печати. Если в классе {@link Application} выставлен флажок coloredMode, определённые строки в консоли будут
 * иметь заданный цвет (зависит от программных аргументов - см. {@link Application#main(String[])}). Цветной вывод в консоли не всегда работает, например
 * в стандартной консоли Windows - cmd, поэтому в таких случаях целесообразно отключать такой способ вывода.
 */
public class PrintUtils {
    private static String MAIN_COLOR = "";
    private static String RED_COLOR = "";
    private static String GREEN_COLOR = "";
    private static String YELLOW_COLOR = "";
    private static String BLUE_COLOR = "";

    static {
        if (Application.isColoredMode()) {
            MAIN_COLOR = "\033[38m";
            RED_COLOR = "\033[38m";
            GREEN_COLOR  = "\033[32m";
            YELLOW_COLOR = "\033[33m";
            BLUE_COLOR = "\033[34m";
        }
    }

    /**
     * Вывод сообщения в консоль стандартным цветом
     * @param text текст сообщения
     */
    public static void print(String text) {
        System.out.println(MAIN_COLOR + text);
    }

    /**
     * Выводит в консоль индикатор пользовательского ввода (означает, что пользователь может вводить команды)
     */
    public static void printInputIndicator() {
        System.out.print(MAIN_COLOR + "> ");
    }

    /**
     * Выводит сообщения в консоль красным цветом
     * @param text текст сообщения
     */
    public static void printRed(String text) {
        System.out.println(RED_COLOR + text);
    }

    /**
     * Вывод сообщения в консоль зелёным цветом
     * @param text текст сообщения
     */
    public static void printGreen(String text) {
        System.out.println(GREEN_COLOR + text);
    }

    /**
     * Вывод сообщения в консоль жёлтым цветом
     * @param text текст сообщения
     */
    public static void printYellow(String text) {
        System.out.println(YELLOW_COLOR + text);
    }

    /**
     * Вывод сообщения в консоль голубым цветом
     * @param text текст сообщения
     */
    public static void printBlue(String text) {
        System.out.println(BLUE_COLOR + text);
    }
}
