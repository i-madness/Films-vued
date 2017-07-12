package io.github.imadness.ats.ui;

import io.github.imadness.ats.tasks.Task;

import java.awt.*;
import java.util.function.Consumer;

/**
 * Типы оповещений
 */
public enum NotificationType {
    /**
     * Обычное оповещение
     */
    STANDARD(TrayIcon.MessageType.WARNING, Terminal::displayTask),

    /**
     * Важное оповещение (или просроченное)
     */
    SEVERE(TrayIcon.MessageType.ERROR, Terminal::displayTaskSevere);

    /**
     * Тип сообщения, выводимого в системном трее
     */
    private TrayIcon.MessageType trayMsgType;

    /**
     * Функция вывода оповещения в консоль
     */
    private Consumer<Task> consolePrintMethod;

    private NotificationType(TrayIcon.MessageType trayMsgType, Consumer<Task> consolePrintMethod) {
        this.trayMsgType = trayMsgType;
        this.consolePrintMethod = consolePrintMethod;
    }

    public TrayIcon.MessageType getTrayMsgType() {
        return this.trayMsgType;
    }

    public Consumer<Task> getConsolePrintMethod() {
        return this.consolePrintMethod;
    }
}
