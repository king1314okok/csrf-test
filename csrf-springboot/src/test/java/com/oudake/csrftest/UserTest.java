package com.oudake.csrftest;

import com.oudake.csrftest.model.Permission;
import com.oudake.csrftest.model.User;
import com.oudake.csrftest.service.IPermissionService;
import com.oudake.csrftest.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private IUserService userService;
    @Autowired
    private IPermissionService permissionService;

    @Test
    public void findPermissionsByUserId() {
        List<Permission> result = permissionService.findPermissionsByUserId(1);
        System.out.println(result);
    }

}
