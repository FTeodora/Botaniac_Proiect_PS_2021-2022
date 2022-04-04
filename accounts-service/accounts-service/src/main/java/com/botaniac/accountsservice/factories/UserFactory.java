package com.botaniac.accountsservice.factories;

import com.botaniac.accountsservice.dto.RegisterDTO;
import com.botaniac.accountsservice.model.entity.User;
import com.botaniac.accountsservice.model.enums.UserRole;

public class UserFactory {
    public static User createDefaultUser(RegisterDTO src){
        User user=src.toUser();
        user.setRole(UserRole.USER);
        return user;
    }
}
