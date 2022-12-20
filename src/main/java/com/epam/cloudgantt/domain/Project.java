package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "project")
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Project extends Auditable {

    @Column(nullable = false)
    String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    public Project(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) && Objects.equals(user, project.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, user);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id + '\'' +
                ", name='" + name +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
