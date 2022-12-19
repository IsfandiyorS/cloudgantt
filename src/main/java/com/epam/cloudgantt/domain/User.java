package com.epam.cloudgantt.domain;

import com.epam.cloudgantt.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class User extends Auditable {

    String firstname;

    String lastname;

    @Column(unique = true)
    String email;

    // todo ask how to add check length of password and how to add to 0004-create-users-table.yaml
//    @Column(columnDefinition = "check (length(password) > 8)")
    String password;

    @OneToOne(mappedBy = "user")
    Project project;

    @Enumerated(EnumType.STRING)
    UserType userType;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "auth_users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    List<Role> roles;

}
