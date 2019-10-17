package com.phonebook.test;

import com.phonebook.test.entities.Phone;
import com.phonebook.test.entities.User;
import com.phonebook.test.repositories.PhoneRepository;
import com.phonebook.test.services.PhoneService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import  static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPhoneService extends Assert {

    @Mock
    private PhoneRepository phoneRepository;

    @InjectMocks
    private PhoneService phoneService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePhone(){
        Phone p1 = new Phone();
        when(phoneRepository.save(any(Phone.class))).thenReturn(any(Phone.class));

        phoneService.save(p1);
        phoneService.save(p1);
        phoneService.save(p1);
        phoneService.save(p1);

        when(phoneRepository.findAll()).thenReturn(Arrays.asList(p1,p1,p1,p1));

        verify(phoneRepository,times(4)).save(any(Phone.class));
        verify(phoneRepository,atMost(4)).save(p1);

    }

    @Test
    public void testFindByPhoneAndUser(){

        when(phoneRepository.findByPhoneAndUser("1",new User())).thenReturn(new Phone());

        phoneRepository.findByPhoneAndUser("1", new User());

        verify(phoneRepository,atLeastOnce()).findByPhoneAndUser(anyString(),any(User.class));
    }

    @Test(expected = NullPointerException.class)
    public void testFindByPhoneAndUserException(){
        doThrow(NullPointerException.class).when(phoneService.findByPhoneAndUser(null,null));
    }
}
