package io.github.imadness.ats.tasks;

import io.github.imadness.ats.ui.NotificationManager;
import io.github.imadness.ats.ui.NotificationType;

import java.awt.*;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ScheduleChecker {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private final NotificationManager notificationManager = new NotificationManager(); // TODO change to DI

    public ScheduleChecker() {
        executor.scheduleAtFixedRate(new CheckingTask(), 0L, 1L, TimeUnit.MINUTES);
    }

    /**
     * Задание проверки задач в расписании. Проверяется, не совпало ли текущее время для каждой задачи
     * в расписании с текущим временем с точностью до минуты; в случае совпадения выводитя системное оповещение
     */
    private class CheckingTask implements Runnable {
        @Override
        public void run() {
            Task task = new Task("New Random Task!", String.valueOf(new Random().nextLong()), new Date());
            try {
                notificationManager.raiseSystemNotification(task, NotificationType.STANDARD);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
}
