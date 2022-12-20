package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "dependency")
@Builder
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Dependency extends Auditable {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "preceded_task_id", referencedColumnName = "id")
    Task precededTask;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "succeeded_task_id", referencedColumnName = "id")
    Task succeededTask;

    public Dependency(){}

    public Task getPrecededTask() {
        return precededTask;
    }

    public void setPrecededTask(Task precededTask) {
        this.precededTask = precededTask;
    }

    public Task getSucceededTask() {
        return succeededTask;
    }

    public void setSucceededTask(Task succeededTask) {
        this.succeededTask = succeededTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dependency that = (Dependency) o;
        return Objects.equals(precededTask, that.precededTask) && Objects.equals(succeededTask, that.succeededTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), precededTask, succeededTask);
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "id=" + id +
                ", precededTask=" + precededTask +
                ", succeededTask=" + succeededTask +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
