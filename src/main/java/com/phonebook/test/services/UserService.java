package com.phonebook.test.services;

import com.phonebook.test.entities.Phone;
import com.phonebook.test.entities.User;
import com.phonebook.test.repositories.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс-сервис для работы с репозиторием User и реализующий дополнительную логику
 * */

@Service(value = "userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {return userRepository.findAll();}

    @Transactional(readOnly = true)
    public User findByName(@NonNull final String name) {return userRepository.findByName(name);}

    @Transactional
    public void save(@NonNull final String name, String ... phone){
        User user = new User(name);
        if(phone != null) {
            user.setPhones(Arrays.stream(phone)
                    .map(o->{Phone newPhone = new Phone(o); newPhone.setUser(user); return newPhone;})
                    .collect(Collectors.toList()));
        }
        userRepository.save(user);
    }

    @Transactional
    public void delete(@NonNull final String name){
        User user = userRepository.findByName(name);
        if(user != null){
            userRepository.delete(user);
        }
    }
}
