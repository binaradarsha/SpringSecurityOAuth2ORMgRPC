package com.binara.dao;

import com.binara.model.User;

import java.util.List;

/**
 * Created by binara on 4/19/17.
 */
public interface UserDAO {

    List<User> getAllUsers();

    User getUser(long id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

}
