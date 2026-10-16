package com.kiet.Student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.kiet.Student.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

        List<Student> users = new ArrayList<>();

        // Add student
        @PostMapping
        public Student addUser(@RequestBody Student u) {
                users.add(u);
                return u;
        }

        // Get all students
        @GetMapping
        public List<Student> getAllUsers() {
                return users;
        }

        // Get student by ID
        @GetMapping("/{id}")
        public Object getUser(@PathVariable Long id) {
                for (Student u : users) {
                        if (u.getId().equals(id)) {
                                return u;
                        }
                }
                return Map.of("message", "Student not found");
        }

        // Update student
        @PutMapping("/{id}")
        public Object updateUser(@PathVariable Long id,
                        @RequestBody Student updated) {
                for (Student u : users) {
                        if (u.getId().equals(id)) {
                                u.setName(updated.getName());
                                u.setEmail(updated.getEmail());
                                u.setBranch(updated.getBranch());
                                u.setYear(updated.getYear());
                                u.setCgpa(updated.getCgpa());
                                return u;
                        }
                }
                return Map.of("message", "Student not found");
        }

        // Delete student
        @DeleteMapping("/{id}")
        public Map<String, String> deleteUser(@PathVariable Long id) {
                boolean removed = users.removeIf(
                                u -> u.getId().equals(id));

                return Map.of("message", removed
                                ? "Student deleted successfully"
                                : "Student not found");
        }

        // Search by branch and year
        @GetMapping("/search")
        public List<Student> searchStudents(
                        @RequestParam String branch,
                        @RequestParam int year) {
                return users.stream()
                                .filter(s -> s.getBranch().equalsIgnoreCase(branch)
                                                && s.getYear() == year)
                                .toList();
        }

        // Find students by minimum CGPA
        @GetMapping("/topper")
        public List<Student> getToppers(@RequestParam double cgpa) {
                return users.stream()
                                .filter(s -> s.getCgpa() >= cgpa)
                                .toList();
        }
}
