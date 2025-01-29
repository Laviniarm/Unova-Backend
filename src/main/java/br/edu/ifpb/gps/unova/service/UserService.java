package br.edu.ifpb.gps.unova.service;

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
}
