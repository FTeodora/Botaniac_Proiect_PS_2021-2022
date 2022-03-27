package com.botaniac.accountsservice.dto;

import com.botaniac.accountsservice.model.entity.User;
import com.botaniac.accountsservice.model.enums.UserRole;

public class ForumPosterDTO {
    private String userName;
    private UserRole role;
    public ForumPosterDTO(User user){
        this.role=user.getRole();
        this.userName=user.getUsername();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
