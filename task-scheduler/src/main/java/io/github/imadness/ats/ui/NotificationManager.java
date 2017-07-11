package io.github.imadness.ats.ui;

import io.github.imadness.ats.tasks.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * Содержит различные методы для вывода оповещений
 */
public class NotificationManager {

    private final SystemTray tray = SystemTray.getSystemTray();

    private final TrayIcon trayIcon;

    public NotificationManager() {
        URL url = ClassLoader.getSystemResource("icon.png");
        Image image = Toolkit.getDefaultToolkit().createImage(url);
        trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        trayIcon.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JOptionPane.showConfirmDialog(null, "Wut?");
                }
            }
        });
    }

    /**
     * Отображает системное оповещение для заданчи
     * @param task задача
     */
    public void raiseSystemNotification(Task task, NotificationType notificationType) throws AWTException {
        trayIcon.displayMessage(task.getName(), task.getDescription(), notificationType.getTrayMsgType());
    }

    /**
     * Отображает оповещение для задачи в консоли
     * @param task
     */
    public void raiseConsoleNotification(Task task, NotificationType notificationType) {
        notificationType.getConsolePrintMethod().accept(task.toConsoleString());
    }
}
