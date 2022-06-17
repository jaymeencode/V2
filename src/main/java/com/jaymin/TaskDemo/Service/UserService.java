package com.jaymin.TaskDemo.Service;

import com.jaymin.TaskDemo.DAO.UserDAO;
import com.jaymin.TaskDemo.DTO.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    public UserDAO userDAO;
    @Transactional
    public String SaveAllUsers(Master response){
        return userDAO.SaveAllUsers(response);
    }
}
