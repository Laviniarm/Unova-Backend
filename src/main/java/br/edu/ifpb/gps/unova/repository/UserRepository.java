package br.edu.ifpb.gps.unova.repository;

import br.edu.ifpb.gps.unova.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmailAndPassword(String email, String password);
}
