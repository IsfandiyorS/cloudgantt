package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "tasks")
@Builder
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Task extends Auditable {

    String name;

    String description;

    LocalDate beginDate;

    LocalDate endDate;

    Long duration;

    Long rank;

    LocalDate deadline;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    Section section;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_type_id", referencedColumnName = "id")
    PlanType planningType;

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public PlanType getPlanningType() {
        return planningType;
    }

    public void setPlanningType(PlanType planningType) {
        this.planningType = planningType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(beginDate, task.beginDate) && Objects.equals(endDate, task.endDate) && Objects.equals(duration, task.duration) && Objects.equals(rank, task.rank) && Objects.equals(deadline, task.deadline) && Objects.equals(section, task.section) && Objects.equals(planningType, task.planningType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, beginDate, endDate, duration, rank, deadline, section, planningType);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", duration=" + duration +
                ", rank=" + rank +
                ", deadline=" + deadline +
                ", section=" + section +
                ", planningType=" + planningType +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
