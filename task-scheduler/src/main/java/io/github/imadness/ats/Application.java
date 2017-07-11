package io.github.imadness.ats;

import io.github.imadness.ats.tasks.ScheduleChecker;
import io.github.imadness.ats.tasks.Task;
import io.github.imadness.ats.tasks.TaskManager;
import io.github.imadness.ats.ui.Terminal;

import java.io.IOException;
import java.util.Date;

/**
 * Точка входа в приложение
 */
public class Application {
    private static final TaskManager taskManager = new TaskManager();
    private static final ScheduleChecker checker = new ScheduleChecker();

    public static void main(String[] args) throws IOException {

        taskManager.addTask(new Task("Task 1", "fkjdkjfs", new Date(System.currentTimeMillis() + 60000)));
        taskManager.addTask(new Task("Task 2", "f5sdf8sdf651f5a4", new Date(System.currentTimeMillis() + 120000)));
        taskManager.addTask(new Task("Task 3", "fsdkjfskdjfuwekwq,,lsadmsakd", new Date(System.currentTimeMillis() + 180000)));
        taskManager.addTask(new Task("task wut", "jfhfsdhfidshf", new Date()));
        taskManager.persistTasks();
        taskManager.getTaskBuffer().clear();
        taskManager.loadTasks();
        checker.startScheduling();
        Terminal.start();
    }

    public static TaskManager getTaskManager() {
        return taskManager;
    }
}
