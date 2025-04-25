package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    SimpleTask testTask1 = new SimpleTask(5, "Позвонить родителям");
    SimpleTask testTask2 = new SimpleTask(8, "Написать письмо Деду Морозу");

    String testEpicSubtask[] = {"Приготовить завтрак", "Приготовить обед", "Приготовить ужин"};
    Epic testTask3 = new Epic(2, testEpicSubtask);

    Meeting testTask4 = new Meeting(1, "Родительское собрание", "Уборка", "18.00");

    @Test
    public void shouldMethodMatchesSimpleTaskTrue() {

        boolean expected = true;
        boolean actual = testTask1.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMethodMatchesSimpleTaskFalse() {

        boolean expected = false;
        boolean actual = testTask2.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMethodMatchesEpicTrue() {

        boolean expected = true;
        boolean actual = testTask3.matches("Приготовить обед");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMethodMatchesEpicFalse() {

        boolean expected = false;
        boolean actual = testTask3.matches("Написать письмо Деду Морозу");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMethodMatchesMeetingTrue() {

        boolean expected = true;
        boolean actual = testTask4.matches("Родительское");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMethodMatchesMeetingFalse() {

        boolean expected = false;
        boolean actual = testTask4.matches("Приготовить ужин");
        Assertions.assertEquals(expected, actual);
    }

}
