package com.happycart.web.application.service;


import com.happycart.web.application.entity.User;
import jakarta.persistence.Tuple;

import java.util.List;

public interface CustomerServicee {
    List<Tuple> getAllUser();
    public User getByEmail(String email);
    public void save(User user);
    public void updateUser(User user);
    public void deleteUser(String email);
}
