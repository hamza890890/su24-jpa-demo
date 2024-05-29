package com.csc340.jpademo.task;

import com.csc340.jpademo.goal.Goal;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @ManyToOne
    @JoinColumn(name = "goal_id", nullable = false)
    private Goal goal;

    @Nonnull
    private String title;
    private String details;
    private String status;

    public Task() {}

    public Task(int taskId, Goal goal, @Nonnull String title, String details, String status) {
        this.taskId = taskId;
        this.goal = goal;
        this.title = title;
        this.details = details;
        this.status = status;
    }

//    public Task(int taskId, Goal goal, String title) {
//        this.taskId = taskId;
//        this.goal = goal;
//        this.title = title;
//
//    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", goal=" + goal +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}