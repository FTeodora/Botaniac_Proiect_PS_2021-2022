package com.botaniac.accountsservice.factories;

import com.botaniac.accountsservice.dto.RegisterDTO;
import com.botaniac.accountsservice.model.entity.User;
import com.botaniac.accountsservice.model.enums.UserRole;

public class UserFactory {
    public static User createDefaultUser(RegisterDTO src){
        return src.toUser().toBuilder().role(UserRole.USER).build();
    }
    public static User promoteToModerator(User user){
        return user.toBuilder().role(UserRole.MODERATOR).build();
    }
}
