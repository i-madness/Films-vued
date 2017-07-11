package io.github.imadness.ats.tasks;

import io.github.imadness.ats.Application;
import io.github.imadness.ats.ui.NotificationManager;
import io.github.imadness.ats.ui.NotificationType;

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *
 */
public class ScheduleChecker {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private final NotificationManager notificationManager = new NotificationManager();

    public void startScheduling() {
        executor.scheduleAtFixedRate(new CheckingTask(), 0L, 1L, TimeUnit.MINUTES);
    }

    /**
     * Задание проверки задач в расписании. Проверяется, не совпало ли текущее время для каждой задачи
     * в расписании с текущим временем с точностью до минуты; в случае совпадения выводитя системное оповещение
     */
    private class CheckingTask implements Runnable {
        @Override
        public void run() {
            Calendar now = GregorianCalendar.getInstance();
            nullifyMillisAndSeconds(now);
            List<Task> taskList = Application.getTaskManager().getTaskBuffer().stream()
                .filter(task -> {
                    System.out.println(task);
                    Calendar taskTime = (Calendar) task.getNotificationTime().clone();
                    nullifyMillisAndSeconds(taskTime);
                    return now.getTime().equals(taskTime.getTime());
                }).collect(Collectors.toList());
            taskList.forEach(task -> {
                    try {
                        notificationManager.raiseSystemNotification(task, NotificationType.STANDARD);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                });
        }

        private void nullifyMillisAndSeconds(Calendar calendar) {
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
        }
    }
}
