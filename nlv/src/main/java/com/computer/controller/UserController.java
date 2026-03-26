package com.computer.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    // In-memory storage (replace with database in production)
    private static List<User> users = new ArrayList<>();
    private static long idCounter = 1;

    static {
        // Demo data
        users.add(new User(idCounter++, "John Doe", "john@example.com", 30));
        users.add(new User(idCounter++, "Jane Smith", "jane@example.com", 25));
        users.add(new User(idCounter++, "Bob Johnson", "bob@example.com", 35));
    }

    // GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    // GET user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.stream()\n                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // POST create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(idCounter++);
        users.add(user);
        return user;
    }

    // PUT update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                updatedUser.setId(id);
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        users.removeIf(u -> u.getId().equals(id));
    }

    // User entity class
    public static class User {
        private Long id;
        private String name;
        private String email;
        private Integer age;

        public User() {}

        public User(Long id, String name, String email, Integer age) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.age = age;
        }

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public Integer getAge() { return age; }
        public void setAge(Integer age) { this.age = age; }
    }
}