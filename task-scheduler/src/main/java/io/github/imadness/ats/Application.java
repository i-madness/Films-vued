package io.github.imadness.ats;

import io.github.imadness.ats.tasks.ScheduleChecker;
import io.github.imadness.ats.tasks.TaskManager;
import io.github.imadness.ats.ui.NotificationManager;
import io.github.imadness.ats.ui.Terminal;

import java.io.IOException;

/**
 * Точка входа в приложение
 */
public class Application {
    // ----- Application services -----
    private static final TaskManager TASK_MANAGER = new TaskManager();
    private static final NotificationManager NOTIFICATION_MANAGER = new NotificationManager();
    private static final ScheduleChecker SCHEDULE_CHECKER = new ScheduleChecker();

    /**
     * Флаг, определяющий наличие цветного вывода текста в консоли
     */
    private static Boolean coloredMode = true;

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("nocolors")) {
            coloredMode = false;
        }
        try {
            TASK_MANAGER.loadTasks();
        } catch (IOException e) {
            Terminal.displayError("Файл журнала задач пуст");
        }
        SCHEDULE_CHECKER.startScheduling();
        Terminal.start();
    }

    public static Boolean isColoredMode() {
        return coloredMode;
    }

    public static TaskManager getTaskManager() {
        return TASK_MANAGER;
    }

    public static NotificationManager getNotificationManager() {
        return NOTIFICATION_MANAGER;
    }
}
