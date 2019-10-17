package com.phonebook.test.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Класс инкапсулирует сущность телефона
 * */

@Entity
@Data
@NoArgsConstructor
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Phone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return phone;
    }
}
