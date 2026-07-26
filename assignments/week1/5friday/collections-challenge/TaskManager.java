package com.cohort.tasks;

import java.util.*;

public class TaskManager {

    List<Task> allTasks;
    Set<String> uniqueTitles;
    Map<String, Task> taskLookup;

    public TaskManager() {
        allTasks = new ArrayList<>();
        uniqueTitles = new HashSet<>();
        taskLookup = new HashMap<>();
    }

    public boolean addTask(Task task) {
        if (task == null) {
            throw new NullPointerException("Task cannot be null");
        }

        if (uniqueTitles.contains(task.getTitle())) {
            System.out.println("Duplicate task blocked!");
            return false;
        }

        allTasks.add(task);
        uniqueTitles.add(task.getTitle());
        taskLookup.put(task.getTaskId(), task);

        return true;
    }

    public Task getTaskById(String id) {
        return taskLookup.get(id);
    }

    public void printRoster() {
        for (Task t : allTasks) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Task task1 = new Task("T1", "Write Primitives Lab");
        Task task2 = new Task("T2", "Configure GitIgnore");
        Task task3 = new Task("T3", "Write Primitives Lab");
        System.out.println(manager.addTask(task1));
        System.out.println(manager.addTask(task2));
        System.out.println(manager.addTask(task3));
        manager.printRoster();
        System.out.println("Retrieve task: " + manager.getTaskById("T2"));
    }
}
