package com.phonebook.test.repositories;

import com.phonebook.test.entities.Phone;
import com.phonebook.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Абстракция информационного хранилища Repository. Взаимосвязь сущности Phone с БД.
 * */

@Repository("phoneRepository")
public interface PhoneRepository  extends JpaRepository<Phone, Long> {
    public Phone findByPhoneAndUser(String phone, User user);
}
