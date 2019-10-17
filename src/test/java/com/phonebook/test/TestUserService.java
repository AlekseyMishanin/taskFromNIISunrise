package com.phonebook.test;

import com.phonebook.test.entities.User;
import com.phonebook.test.repositories.UserRepository;
import com.phonebook.test.services.UserService;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll(){
        List<User> list = Lists.newArrayList(new User(),new User(),new User());
        when(userRepository.findAll()).thenReturn(list);

        List<User> res = userService.findAll();

        Assert.assertNotNull(res);
        Assert.assertEquals(3,res.size());
        Assert.assertTrue( res instanceof List);

        verify(userRepository,atLeastOnce()).findAll();
    }

    @Test
    public void testFindByNameNotException(){
        when(userRepository.findByName("Ivan")).thenReturn(new User("Ivan"));

        User userRes = userService.findByName("Ivan");
        Assert.assertEquals(userRes, new User("Ivan"));
        Assert.assertNull(userRes.getId());
        Assert.assertNull(userRes.getPhones());

        verify(userRepository,atLeastOnce()).findByName(anyString());
        verify(userRepository,times(1)).findByName(eq("Ivan"));

        when(userRepository.findByName(null)).thenThrow(NullPointerException.class);
    }

    @Test(expected = NullPointerException.class)
    public void testFindByNameWithException(){
       when(userRepository.findByName(null)).thenThrow(NullPointerException.class);
        userService.findByName(null);
    }
}
