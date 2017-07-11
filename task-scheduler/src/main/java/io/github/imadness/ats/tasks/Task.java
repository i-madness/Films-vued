package io.github.imadness.ats.tasks;

import java.util.Date;
import java.util.Objects;

/**
 * Запланированная задача
 */
public class Task {
    private String name;
    private String description;
    private Date notificationTime;
    // TODO contacts;


    public Task(String name, String description, Date notificationTime) {
        this.name = name;
        this.description = description;
        this.notificationTime = notificationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(Date notificationTime) {
        this.notificationTime = notificationTime;
    }

    public String toConsoleString() {
        return "[Задача " + name + "]\n" + description + "\n" + "Запланировано на" + notificationTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", notificationTime=" + notificationTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(notificationTime, task.notificationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, notificationTime);
    }
}
