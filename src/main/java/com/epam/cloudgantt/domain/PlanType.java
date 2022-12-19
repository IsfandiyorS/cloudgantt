package com.epam.cloudgantt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PlanType extends Auditable {

    String typeName;

    @OneToMany(mappedBy = "planningType")
    List<Task> taskList;

}
