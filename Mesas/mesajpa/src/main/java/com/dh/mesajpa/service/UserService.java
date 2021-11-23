package com.dh.mesajpa.service;

import com.dh.mesajpa.persistence.entity.UserEntity;
import com.dh.mesajpa.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public UserEntity find(Integer id) {
        Optional<UserEntity> user = repo.findById(id);
        if(user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    public UserEntity create(UserEntity user) {
        return repo.save(user);
    }
}
