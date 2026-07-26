package com.cohort.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;


public class RevisedTaskManager {
    private final List<RevisedTask> allTasks;
    private final Set<String> uniqueTitles;
    private final Map<String, RevisedTask> taskLookup;

    public RevisedTaskManager() {
        allTasks = new ArrayList<>();
        uniqueTitles = new HashSet<>();
        taskLookup = new HashMap<>();
    }

    public boolean addTask(RevisedTask task) {
        String taskTitle = task.getTitle();
        String taskId = task.getTaskId();

        if (taskLookup.containsKey(taskId) || uniqueTitles.contains(taskTitle)) {
            System.out.println("Duplicate task blocked!");
            return false;
        }

        allTasks.add(task);
        uniqueTitles.add(taskTitle);
        taskLookup.put(taskId, task);

        return true;
    }

    public RevisedTask getTaskById(String id) {
        return taskLookup.get(id);
    }

    public void printRoster() {
        for (RevisedTask t : allTasks) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        RevisedTaskManager manager = new RevisedTaskManager();
        RevisedTask task1 = new RevisedTask("T1", "Write Primitives Lab");
        RevisedTask task2 = new RevisedTask("T2", "Configure GitIgnore");
        RevisedTask task3 = new RevisedTask("T3", "Write Primitives Lab");
        System.out.println(manager.addTask(task1));
        System.out.println(manager.addTask(task2));
        System.out.println(manager.addTask(task3));
        manager.printRoster();
        System.out.println("Retrieve task: " + manager.getTaskById("T2"));
    }
}
