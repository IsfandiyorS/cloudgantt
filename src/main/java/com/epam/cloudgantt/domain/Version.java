package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Entity
@Table(name = "version")
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Version extends Auditable {

    Long versionNumber;

    String versionName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    Project project;

    public Version() {
    }

    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Version version = (Version) o;
        return Objects.equals(versionNumber, version.versionNumber) && Objects.equals(versionName, version.versionName) && Objects.equals(project, version.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), versionNumber, versionName, project);
    }

    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", versionNumber=" + versionNumber +
                ", versionName='" + versionName + '\'' +
                ", project=" + project +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}