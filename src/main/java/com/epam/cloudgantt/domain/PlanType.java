package com.epam.cloudgantt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "plan_type")
@Builder
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PlanType extends Auditable {

    String typeName;

    public PlanType(){}

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlanType planType = (PlanType) o;
        return Objects.equals(typeName, planType.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeName);
    }

    @Override
    public String toString() {
        return "PlanType{" +
                "id=" + id + '\'' +
                ", typeName='" + typeName +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
