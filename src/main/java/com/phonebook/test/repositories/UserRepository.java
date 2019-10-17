package com.phonebook.test.repositories;

import com.phonebook.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Абстракция информационного хранилища Repository. Взаимосвязь сущности User с БД.
 * */

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByName(String name);
}
