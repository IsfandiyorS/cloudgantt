package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.*;

@Entity
@Table(name = "sections")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Section extends Auditable {

    String name;

    Long rank;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "version_id", referencedColumnName = "id")
    Version version;

    @OneToMany(mappedBy = "section")
    List<Task> tasks;
}
