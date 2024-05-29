package com.csc340.jpademo.goal;

import com.csc340.jpademo.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * GoalController
 */
@Controller
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    GoalService goalService;

    @GetMapping("/all")
    public String getAllGoals(Model model) {
        model.addAttribute("goalList", goalService.getAllGoals());
        return "goal-list";
    }

    @GetMapping("/{goalId}")
    public String getGoalById(@PathVariable int goalId, Model model) {
        model.addAttribute("goal", goalService.getGoalById(goalId));
        return "goal-detail";
    }

    @PostMapping("/create")
    public String addNewGoal(Goal goal) {
        goalService.addNewGoal(goal);
        return "redirect:/goals/all";
    }

    @PostMapping("/update")
    public String updateGoal(Goal goal) {
        goalService.updateGoal(goal);
        return "redirect:/goals/" + goal.getGoalId();
    }

    @GetMapping("/update/{goalId}")
    public String showUpdateForm(@PathVariable int goalId, Model model) {
        model.addAttribute("goal", goalService.getGoalById(goalId));
        return "goal-update";
    }

    @GetMapping("/delete/{goalId}")
    public String deleteGoalById(@PathVariable int goalId) {
        goalService.deleteGoalById(goalId);
        return "redirect:/goals/all";
    }
}
