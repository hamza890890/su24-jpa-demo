package com.csc340.jpademo.goal;

import com.csc340.jpademo.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Goal getGoalById(int goalId) {
        return goalRepository.findById(goalId).orElse(null);
    }

    public void addNewGoal(Goal goal) {
        goalRepository.save(goal);
    }

    public void updateGoal(Goal goal) {
        goalRepository.save(goal);
    }

    public void deleteGoalById(int goalId) {
        goalRepository.deleteById(goalId);
    }
}
