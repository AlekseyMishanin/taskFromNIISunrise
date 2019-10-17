package com.phonebook.test;

import com.phonebook.test.entities.User;
import com.phonebook.test.utilites.XmlConverter;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestXmlConverter {

    private XmlConverter xmlConverter;

    @Before
    public void setUp(){
        xmlConverter = new XmlConverter();
    }

    @Test
    public void testXmlConverter(){
        User u1 = new User("user1");
        u1.setId(1l);
        User u2 = new User("user2");
        u2.setId(2l);
        List<User> list = Lists.newArrayList(u1,u2);
        xmlConverter.loadToXml(list);

        File file = new File("users.xml");
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.length()>0);
    }
}
