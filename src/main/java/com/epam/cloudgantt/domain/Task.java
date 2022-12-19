package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Task extends Auditable {

    String name;

    String description;

    LocalDate beginDate;

    LocalDate endDate;

    Long duration;

    Double rank;

    // fixme what type should be deadline;
    LocalDateTime deadline;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    Section section;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_type_id", referencedColumnName = "id")
    PlanType planningType;

}
