package com.csc340.jpademo.task;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
// @Query(value = "select s from tasks s where gpa > ?1", nativeQuery = true)
// public List<Task> getHonorsStudents(double gpa);
}