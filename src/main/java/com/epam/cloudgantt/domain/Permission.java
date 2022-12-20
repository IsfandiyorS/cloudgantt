package com.epam.cloudgantt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "permissions")
@Builder
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Permission extends Auditable implements GrantedAuthority {
    @Column(unique = true)
    String code;

    String name;

    public Permission(){}

    @Override
    public String getAuthority() {
        return getCode();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Permission that = (Permission) o;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, name);
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
