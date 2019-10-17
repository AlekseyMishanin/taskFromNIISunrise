package com.phonebook.test.utilites;

import com.phonebook.test.entities.Phone;
import com.phonebook.test.entities.User;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Класс предоставляет возможность выгрузки списка пользователей с
 * привязанными телефонами из БД в локальную файловую систему в формате XML.
 * */

@Component
public class XmlConverter {

    public void loadToXml(List<User> list){

        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(
                    new FileWriter("users.xml"));

            writer.writeStartDocument();
            writer.writeStartElement("users");
            for (User user:
            list) {
                writer.writeStartElement("user");
                writer.writeStartElement("id");
                writer.writeCharacters(Long.toString(user.getId()));
                writer.writeEndElement();
                writer.writeStartElement("first_name");
                writer.writeCharacters(user.getName());
                writer.writeEndElement();
                writer.writeStartElement("phones");
                if(user.getPhones()!=null)
                for (Phone phone:
                     user.getPhones()) {
                    writer.writeStartElement("phone");
                    writer.writeCharacters(phone.getPhone());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeEndElement();
            }

            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
