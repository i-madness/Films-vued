package io.github.imadness.ats;

import io.github.imadness.ats.tasks.ScheduleChecker;
import io.github.imadness.ats.ui.Terminal;

/**
 * Точка входа в приложение
 */
public class Application {
    public static void main(String[] args) {
        ScheduleChecker checker = new ScheduleChecker();
        Terminal terminal = new Terminal();
    }
}
