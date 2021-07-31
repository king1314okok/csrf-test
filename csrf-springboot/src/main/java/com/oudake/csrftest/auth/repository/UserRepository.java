package com.oudake.csrftest.auth.repository;

import com.oudake.csrftest.auth.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author wangyi
 */
@Repository
public class UserRepository {

    public User findUserByUsername(String username) {
        return new User("123", "wangyi", "b4af804009cb036a4ccdc33431ef9ac9");
    }

}
