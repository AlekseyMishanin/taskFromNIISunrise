package com.phonebook.test.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

/**
 * Класс инкапсулирует сущность пользователя
 * */

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String name;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Phone> phones;

    @Override
    public String toString() {
        return "User { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", " + getPhone() +
                '}';
    }

    public User(String name) {
        this.name = name;
    }

    private String getPhone(){
        StringBuilder sb = new StringBuilder("phones:\n");
        phones.stream().forEach(phone->sb.append(phone.getPhone() + " "));
        return sb.toString();
    }
}
