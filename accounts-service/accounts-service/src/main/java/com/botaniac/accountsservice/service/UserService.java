package com.botaniac.accountsservice.service;

import com.botaniac.accountsservice.dto.ForumPosterDTO;
import com.botaniac.accountsservice.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepo userRepo;
    public ForumPosterDTO getUserUsername(String id){
        return new ForumPosterDTO(userRepo.findById(id).get());
    }
}
