package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMethodMatchesWithExistingRequest() {
        SimpleTask testTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask testTask2 = new SimpleTask(8, "Написать письмо Деду Морозу");

        String testEpicSubtask[] = {"Приготовить завтрак", "Приготовить обед", "Приготовить ужин"};
        Epic testTask3 = new Epic(2, testEpicSubtask);

        Meeting testTask4 = new Meeting(1, "Родительское собрание", "Уборка", "18.00");

        Todos todos = new Todos();

        todos.add(testTask1);
        todos.add(testTask2);
        todos.add(testTask3);
        todos.add(testTask4);

        Task[] expected = {testTask1};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldMethodMatchesNoExistingRequest() {
        SimpleTask testTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask testTask2 = new SimpleTask(8, "Написать письмо Деду Морозу");

        String testEpicSubtask[] = {"Приготовить завтрак", "Приготовить обед", "Приготовить ужин"};
        Epic testTask3 = new Epic(2, testEpicSubtask);

        Meeting testTask4 = new Meeting(1, "Родительское собрание", "Уборка", "18.00");

        Todos todos = new Todos();

        todos.add(testTask1);
        todos.add(testTask2);
        todos.add(testTask3);
        todos.add(testTask4);

        Task[] expected = {};
        Task[] actual = todos.search("Поздравить с Новым Годом");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldMethodMatchesWithSeveralExistingRequest() {
        SimpleTask testTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask testTask2 = new SimpleTask(8, "Написать письмо Деду Морозу");
        SimpleTask testTask5 = new SimpleTask(4, "Позвонить брату");

        String testEpicSubtask[] = {"Приготовить завтрак", "Приготовить обед", "Приготовить ужин"};
        Epic testTask3 = new Epic(2, testEpicSubtask);

        Meeting testTask4 = new Meeting(1, "Родительское собрание", "Уборка", "18.00");

        Todos todos = new Todos();

        todos.add(testTask1);
        todos.add(testTask2);
        todos.add(testTask3);
        todos.add(testTask4);
        todos.add(testTask5);

        Task[] expected = {testTask1, testTask5};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }
}
