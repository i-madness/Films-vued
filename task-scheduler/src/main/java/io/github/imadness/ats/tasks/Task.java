package io.github.imadness.ats.tasks;

import java.time.Instant;
import java.util.Objects;

/**
 * Запланированная задача
 */
public class Task {
    private String name;
    private String description;
    private Instant notificationTime;
    // TODO contacts;


    public Task(String name, String description, Instant notificationTime) {
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

    public Instant getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(Instant notificationTime) {
        this.notificationTime = notificationTime;
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
