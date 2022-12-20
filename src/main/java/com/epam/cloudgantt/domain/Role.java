package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "roles")
@Builder
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Role extends Auditable implements GrantedAuthority {

    @Column(unique = true)
    String code;

    String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "auth_roles_permissions",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    List<Permission> permissions;

    public Role() {
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return Objects.equals(code, role.code) && Objects.equals(name, role.name) && Objects.equals(permissions, role.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, name, permissions);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", code='" + code +
                ", name='" + name +
                ", permissions=" + permissions +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
