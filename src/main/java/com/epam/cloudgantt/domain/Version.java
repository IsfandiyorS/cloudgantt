package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Version extends Auditable {

    Long versionNumber;

    String versionName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    Project project;

    @OneToMany(mappedBy = "version")
    Set<Section> sections;
}
 // todo onDelete and onUpdate should be deleted