package com.epam.cloudgantt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Auditable implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

}
