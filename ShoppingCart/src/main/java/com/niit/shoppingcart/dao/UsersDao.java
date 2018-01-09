package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Users;

public interface UsersDao {
public void addUsers(Users users);
public Users getUsersById(String userId);
public List<Users> getAllUsers();
public Users getUsersByUsername(String userName);
public void updateUsers(Users users);
public void deleteUsers(String userId);
}
