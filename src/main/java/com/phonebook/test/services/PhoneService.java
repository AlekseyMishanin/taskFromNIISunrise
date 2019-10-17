package com.phonebook.test.services;

import com.phonebook.test.entities.Phone;
import com.phonebook.test.entities.User;
import com.phonebook.test.repositories.PhoneRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Класс-сервис для работы с репозиторием Phone и реализующий дополнительную логику
 * */

@Service(value = "phoneService")
public class PhoneService {

    private PhoneRepository phoneRepository;

    @Autowired
    public void setPhoneRepository(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Transactional
    public void save(@NonNull final Phone phone){phoneRepository.save(phone);}

    @Transactional
    public void deleteAll(@NonNull final Phone phone){phoneRepository.delete(phone);}

    @Transactional
    public void deletePhoneByUser(@NonNull final String phone, @NonNull final User user){
        Phone fPhone = phoneRepository.findByPhoneAndUser(phone,user);
        if(fPhone!=null){
            phoneRepository.delete(fPhone);
        }
    }

    @Transactional(readOnly = true)
    public Phone findByPhoneAndUser(@NonNull final String phone, @NonNull final User user){
        return phoneRepository.findByPhoneAndUser(phone,user);
    }
}
