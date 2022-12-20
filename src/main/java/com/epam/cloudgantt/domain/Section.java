package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "sections")
@Builder
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Section extends Auditable {

    String name;

    Long rank;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "version_id", referencedColumnName = "id")
    Version version;

    public Section() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Section section = (Section) o;
        return Objects.equals(name, section.name) && Objects.equals(rank, section.rank) && Objects.equals(version, section.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, rank, version);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id + '\'' +
                ", name='" + name +
                ", rank=" + rank +
                ", version=" + version +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
