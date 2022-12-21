package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import static lombok.AccessLevel.PROTECTED;

/*
super class new
 */
@MappedSuperclass
@AllArgsConstructor
@FieldDefaults(level = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreatedBy
    Long createdBy;

    @CreatedDate
    @Column(columnDefinition = "timestamp default now()")
    LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedBy
    Long lastModifiedBy;

    @LastModifiedDate
    LocalDateTime lastModifiedDate;

    public Auditable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditable auditable = (Auditable) o;
        return Objects.equals(id, auditable.id) && Objects.equals(createdBy, auditable.createdBy) && Objects.equals(createdDate, auditable.createdDate) && Objects.equals(lastModifiedBy, auditable.lastModifiedBy) && Objects.equals(lastModifiedDate, auditable.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }

    @Override
    public String toString() {
        return "Auditable{" +
                "id=" + id +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}

// todo
//  1. list foreign keys must be defined by code convention -> done
//  2. user password must be changed to base64 or another password encoder
//  3. created_by should be changed to bigint               -> done
//  4. primary keylar bigint bir qanaqdir xato ketib qolmasin????       -> done
//  5. do not use lombok for getter and setter              -> done
//  6. env split it to prod and dev sections                -> there are some problems with running on gradle
//  7. deadline should be localdate format in task entity   -> done
//  8. mapped by must be deleted                            -> done
//  9. in OneToOne ManyToOne relationship fetch type should be lazy     -> done
//  10. learn jasypt