package br.edu.ifpb.gps.unova.service;

import java.util.Optional;

import br.edu.ifpb.gps.unova.model.User;
import br.edu.ifpb.gps.unova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> loginUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> updateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());

        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setName(user.getName());
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setRole(user.getRole());
            userToUpdate.setPhoneNumber(user.getPhoneNumber());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setAddress(user.getAddress());

            return Optional.of(userRepository.save(userToUpdate));
        }
        return Optional.empty();
    }

    public boolean deleteUser(Long id) {
        Optional<User> userToDelete = userRepository.findById(id);

        if (userToDelete.isPresent()) {
            userRepository.delete(userToDelete.get());
            return true;
        } else {
            return false;
        }
    }
}
