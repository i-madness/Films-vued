package io.github.imadness.ats.ui;

import java.awt.*;
import java.util.function.Consumer;

/**
 * Типы оповещений
 */
public enum NotificationType {
    /**
     * Обычное оповещение
     */
    STANDARD(TrayIcon.MessageType.WARNING, PrintUtils::print),

    /**
     * Важное оповещение (или просроченное)
     */
    SEVERE(TrayIcon.MessageType.ERROR, PrintUtils::printRed);

    /**
     * Тип сообщения, выводимого в системном трее
     */
    private TrayIcon.MessageType trayMsgType;

    /**
     * Функция вывода оповещения в консоль
     */
    private Consumer<String> consolePrintMethod;

    private NotificationType(TrayIcon.MessageType trayMsgType, Consumer<String> consolePrintMethod) {
        this.trayMsgType = trayMsgType;
        this.consolePrintMethod = consolePrintMethod;
    }

    public TrayIcon.MessageType getTrayMsgType() {
        return this.trayMsgType;
    }

    public Consumer<String> getConsolePrintMethod() {
        return this.consolePrintMethod;
    }
}
