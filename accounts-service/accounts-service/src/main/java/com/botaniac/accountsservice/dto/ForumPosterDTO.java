package com.botaniac.accountsservice.dto;

import com.botaniac.accountsservice.model.entity.User;
import com.botaniac.accountsservice.model.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ForumPosterDTO {
    private String username;
    private UserRole role;
    public ForumPosterDTO(User user){
        this.role=user.getRole();
        this.username=user.getUsername();
    }
}
