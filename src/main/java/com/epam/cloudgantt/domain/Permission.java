package com.epam.cloudgantt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "permissions")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Permission extends Auditable implements GrantedAuthority {
    @Column(unique = true)
    String code;

    String name;

    @Override
    public String getAuthority() {
        return getCode();
    }

}
