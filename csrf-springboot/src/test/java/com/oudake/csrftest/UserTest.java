package com.oudake.csrftest;

import com.oudake.csrftest.model.User;
import com.oudake.csrftest.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("king");
        user.setPassword("111");
        int result = userService.addUser(user);
        System.out.println(result);
    }

}
