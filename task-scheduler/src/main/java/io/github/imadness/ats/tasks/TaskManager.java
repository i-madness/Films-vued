package io.github.imadness.ats.tasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import io.github.imadness.ats.ui.Terminal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Содержит буфер имеющихся заданий и методы его фиксации в файловой системе
 */
public class TaskManager {
    /**
     * Маппер объектов Jackson
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Файл журнала задач
     */
    private static final File TASK_JOURNAL_FILE = new File("tasks.json");

    /**
     * Тип, используемый Jackson при парсинге json-файла
     */
    private static final CollectionType TASK_BUFFER_TYPE = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Task.class);

    /**
     * Коллекция, в которой хранятся все задания в системе
     */
    private List<Task> taskBuffer = new ArrayList<>();

    /**
     * Конструктор. На этом этапе создаётся файл журнала задач, если он не существует
     */
    public TaskManager() {
        if (!TASK_JOURNAL_FILE.exists()) {
            try {
                TASK_JOURNAL_FILE.createNewFile();
            } catch (IOException e) {
                Terminal.displayError("Ошибка при создании файла журнала задач", e);
            }
        }
    }

    /**
     * Загружает буфер заданий из файла
     */
    public void loadTasks() throws IOException {
        taskBuffer = OBJECT_MAPPER.readValue(TASK_JOURNAL_FILE, TASK_BUFFER_TYPE);
    }

    /**
     * Сохраняет буфер заданий в файл
     * @throws IOException
     */
    public void persistTasks() throws IOException {
        OBJECT_MAPPER.writeValue(TASK_JOURNAL_FILE, taskBuffer);
    }

    /**
     * Добавляет задачу в буфер
     * @param task задача для добавления
     */
    public void addTask(Task task) {
        taskBuffer.add(task);
    }

    /**
     * Удаляет задачу из буфера
     * @param task задача для удаления
     */
    public void removeTask(Task task) {
        taskBuffer.remove(task);
    }

    /**
     * Находит задачу в буфере по имени и описанию
     * @param name имя задачи
     * @param description описание задачи
     * @return искомая задача или null, если не найдено соответствий
     */
    public Task findTask(final String name, final String description) {
        for (Task task : taskBuffer) {
            if (task.getName().equals(name) && task.getDescription().equals(description)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Очистка буфера задач
     */
    public void clearBuffer() {
        taskBuffer.clear();
    }

    /**
     * Возвращает Stream для коллекции задач
     * @return объект {@link Stream}
     */
    public Stream<Task> taskStream() {
        return taskBuffer.stream();
    }
}
