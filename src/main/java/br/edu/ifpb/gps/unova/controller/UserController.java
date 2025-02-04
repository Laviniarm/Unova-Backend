package br.edu.ifpb.gps.unova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifpb.gps.unova.model.User;
import br.edu.ifpb.gps.unova.model.DTO.LoginDTO;
import br.edu.ifpb.gps.unova.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.created(null).body(userService.registerUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@RequestParam Long id) {
        java.util.Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO login) {
        java.util.Optional<User> userOptional = userService.loginUser(login.getEmail(), login.getPassword());
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        if (userService.updateUser(user).isPresent()) {
            User updatedUser = userService.updateUser(user).get();
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (userService.getUserById(id).isPresent()) {
            user.setId(id);
            User updatedUser = userService.updateUser(user).get();
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody User user) {
        if (userService.getUserById(user.getId()).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(user.getId());
        return ResponseEntity.noContent().build();
    }
}
