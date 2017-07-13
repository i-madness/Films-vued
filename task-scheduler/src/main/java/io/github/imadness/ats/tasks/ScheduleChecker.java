package io.github.imadness.ats.tasks;

import io.github.imadness.ats.Application;
import io.github.imadness.ats.ui.NotificationManager;
import io.github.imadness.ats.ui.NotificationType;
import io.github.imadness.ats.ui.Terminal;

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Периодически проверяет задания в расписании
 */
public class ScheduleChecker {
    /**
     * Исполнитель запланированных Runnable для проверки расписания задач
     */
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /**
     * Показатель активности Executor'а
     */
    private Boolean isActive = false;

    /**
     * Начинает проверку задач в расписании
     */
    public void startScheduling() {
        if (!isActive) {
            executor.scheduleAtFixedRate(new CheckingTask(), 0L, 20L, TimeUnit.SECONDS);
            isActive = true;
        }
    }

    /**
     * Задание проверки задач в расписании. Проверяется, не совпало ли текущее время для каждой задачи
     * в расписании с текущим временем с точностью до минуты; в случае совпадения выводитя системное оповещение
     */
    private class CheckingTask implements Runnable {
        @Override
        public void run() {
            TaskManager taskManager = Application.getTaskManager();
            NotificationManager notificationManager = Application.getNotificationManager();
            Calendar now = GregorianCalendar.getInstance();
            nullifyMillisAndSeconds(now);
            taskManager.getTaskBuffer().stream()
                .filter(task -> {
                    Calendar taskTime = (Calendar) task.getNotificationTime().clone();
                    nullifyMillisAndSeconds(taskTime);
                    return now.getTime().equals(taskTime.getTime());
                })
                .forEach(task -> {
                    try {
                        notificationManager.raiseSystemNotification(task, NotificationType.STANDARD);
                        notificationManager.raiseConsoleNotification(task, NotificationType.STANDARD);
                        taskManager.removeTask(task);
                    } catch (AWTException e) {
                        Terminal.displayError("Не удалось вывести оповещение", e);
                    }
                });
        }

        /**
         * Обнуляет миллесекунды и секунды в календаре
         * @param calendar инстанс {@link Calendar}
         */
        private void nullifyMillisAndSeconds(Calendar calendar) {
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
        }
    }

}
