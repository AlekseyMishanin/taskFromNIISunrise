package com.phonebook.test;

import com.phonebook.test.entities.Phone;
import com.phonebook.test.entities.User;
import com.phonebook.test.services.PhoneService;
import com.phonebook.test.services.UserService;
import com.phonebook.test.utilites.XmlConverter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Класс инжектит сервисы, xml-конвертер и вызывает соответствующие методы внедренных зависимостей
 * */
@Component
public class ApplicationHeart {

    private UserService userService;
    private PhoneService phoneService;
    private XmlConverter xmlConverter;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @Autowired
    public void setXmlConverter(XmlConverter xmlConverter) {
        this.xmlConverter = xmlConverter;
    }

    /**
     * Метод возвращает список всех пользователей
     * @return - список пользователей
     * */
    public List<User> findAll(){return userService.findAll();}

    /**
     * Метод добавляет в БД нового пользователя
     * @param name - имя пользователя
     * @param phone - массив телефонов польвателя
     * */
    public void addUser(@NonNull final String name, String ... phone){
        if(userService.findByName(name)==null)
        userService.save(name, phone);
    }

    /**
     * Метод удаляет пользователя из БД
     * @param name - имя пользователя
     * */
    public void deleteUser(@NonNull final String name){
        userService.delete(name);
    }

    /**
     * Метод добавляет новый телефон в список телефонов привязанных к пользователю
     * @param toUser - имя пользователя
     * @param phone - новый телефон польвателя
     * */
    public void addPhoneToUser(@NonNull final String toUser, @NonNull final String phone){
        User user = userService.findByName(toUser);
        if(user!=null){
            Phone newPhone = new Phone(phone);
            newPhone.setUser(user);
            phoneService.save(newPhone);
        }
    }

    /**
     * Метод удаляет выбранный номер телефона из профиля пользователя
     * @param toUser - имя пользователя
     * @param phone - номер телефона для удаления
     * */
    public void deletePhoneUser(@NonNull final String toUser, @NonNull final String phone){
        User user = userService.findByName(toUser);
        if(user!=null){
            phoneService.deletePhoneByUser(phone,user);
        }
    }

    /**
     * Метод выгружает список всех пользователей с телефонами в файл формата XML
     * */
    public void saveAllUsersToXml(){
        xmlConverter.loadToXml(userService.findAll());
    }
}
