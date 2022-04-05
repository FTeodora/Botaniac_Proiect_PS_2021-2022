package com.botaniac.accountsservice.model.entity;

import com.botaniac.accountsservice.model.enums.UserRole;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="user")
@Builder(toBuilder=true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(unique = true,nullable = false,name = "e_mail")
    private String email;
    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String password;
    @Column(nullable = false)
    private UserRole role;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime joinedAt;
    @Column
    @ColumnDefault(value="NULL")
    private LocalDate birthday;
    @Column
    private String profilePicture;
}
