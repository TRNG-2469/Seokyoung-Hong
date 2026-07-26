package com.cohort.ai;

public class RevisedTask {
    private String taskId;
    private String title;
    private boolean isCompleted;

    public RevisedTask(String taskId, String title) {
        if (isNullOrNonEmpty(taskId) || isNullOrNonEmpty(title)) {

            throw new IllegalArgumentException("Cannot be null or nonempty");

        }
        this.taskId = taskId;
        this.title = title;
    }

    public static boolean isNullOrNonEmpty(String val) {
        if (val == null || val.isEmpty()) {
            return true;
        }
        return false;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        if (isNullOrNonEmpty(taskId)) {
            throw new IllegalArgumentException("Cannot be null or nonempty");
        }
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (isNullOrNonEmpty(title)) {
            throw new IllegalArgumentException("Cannot be null or nonempty");
        }
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "[" + taskId + ": " + title + "] Completion: " + (isCompleted ? "T" : "F");
    }
}
