package com.csc340.jpademo.task;

import com.csc340.jpademo.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/all")
    public String getAllTask(Model model) {
        model.addAttribute("taskList", taskService.getAllTasks());
        return "task-list";
    }

    @GetMapping("{taskId}")
    public String getTaskById(@PathVariable int taskId, Model model) {
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task-detail";
    }

    @PostMapping("create")
    public String addNewTask(Task task) {
        try {
            taskService.addNewTask(task);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
        }
        return "redirect:/tasks/all";
    }


    @PostMapping("/update")
    public String updateTask(Task task) {
        taskService.updateTask(task);
        System.out.println("--taskId--");
        System.out.println(task.getTaskId());
        return "redirect:/tasks/" + task.getTaskId();
    }

    @GetMapping("/update/{taskId}")
    public String showUpdateForm(@PathVariable int taskId, Model model) {
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task-update";
    }



    @GetMapping("/delete/{taskId}")
    public String deleteTaskById(@PathVariable int taskId) {
        taskService.deleteTaskById(taskId);
        return "redirect:/tasks/all";
    }
}