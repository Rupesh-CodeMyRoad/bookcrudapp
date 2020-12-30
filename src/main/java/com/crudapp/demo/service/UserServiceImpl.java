package com.crudapp.demo.service;

import com.crudapp.demo.model.Role;
import com.crudapp.demo.model.User;
import com.crudapp.demo.repository.RoleRepo;
import com.crudapp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

//    @Autowired
//    RoleRepo roleRepo;


    @Override
    public User registerUser(User user) {
        User user1 =new User();



        user1.setUsername(user.getUsername());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newPassword = encoder.encode(user.getPassword());
        user1.setPassword(newPassword);
        user1.setEmail(user.getEmail());
        user1.setMobileNumber(user.getMobileNumber());
        user1.setAddress(user.getAddress());
        user1 = userRepository.save(user1);
//        roleRepo.setUserRole(user1.getUser_id(),1L);
        return user1;
    }
}
