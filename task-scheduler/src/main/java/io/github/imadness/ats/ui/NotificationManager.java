package io.github.imadness.ats.ui;

import io.github.imadness.ats.tasks.Task;

import java.awt.*;
import java.net.URL;

/**
 * Содержит различные методы для вывода оповещений
 */
public class NotificationManager {
    /**
     * Трей системы, в котором выводятся оповещения
     */
    private final SystemTray tray = SystemTray.getSystemTray();

    /**
     * Иконка, отображаемая в трее
     */
    private TrayIcon trayIcon;

    /**
     * Конструктор. На этом этапе происходит нициализация trayIcon и обработчиков событий
     */
    public NotificationManager() {
        if (tray.isSupported()) {
            URL url = ClassLoader.getSystemResource("icon.png");
            Image image = Toolkit.getDefaultToolkit().createImage(url);
            trayIcon = new TrayIcon(image, "Awesome Task Scheduler");
            trayIcon.setImageAutoSize(true);
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                Terminal.displayError("Не удалось добавить иконку приложения в системный трей", e);
            }
        }
    }

    /**
     * Отображает системное оповещение для заданчи
     * @param task задача
     */
    public void raiseSystemNotification(Task task, NotificationType notificationType) throws AWTException {
        if (tray.isSupported()) {
            trayIcon.displayMessage(task.getName(), task.getDescription(), notificationType.getTrayMsgType());
        }
    }

    /**
     * Отображает оповещение для задачи в консоли
     * @param task
     */
    public void raiseConsoleNotification(Task task, NotificationType notificationType) {
        notificationType.getConsolePrintMethod().accept(task);
        Terminal.displaySeparator();
    }
}
