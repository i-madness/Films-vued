package io.github.imadness.ats;

import io.github.imadness.ats.tasks.ScheduleChecker;
import io.github.imadness.ats.tasks.TaskManager;
import io.github.imadness.ats.ui.NotificationManager;
import io.github.imadness.ats.ui.Terminal;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Точка входа в приложение
 */
public class Application {
    // ----- Application services -----
    private static final TaskManager TASK_MANAGER = new TaskManager();
    private static final NotificationManager NOTIFICATION_MANAGER = new NotificationManager();
    private static final ScheduleChecker SCHEDULE_CHECKER = new ScheduleChecker();
    // ----- Other constants -----
    public static final SimpleDateFormat CONSOLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public static void main(String[] args) throws IOException {
        TASK_MANAGER.loadTasks();
        SCHEDULE_CHECKER.startScheduling();
        Terminal.start();
    }

    public static TaskManager getTaskManager() {
        return TASK_MANAGER;
    }

    public static NotificationManager getNotificationManager() {
        return NOTIFICATION_MANAGER;
    }
}
