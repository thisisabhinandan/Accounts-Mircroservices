package com.example.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
@ToString
public class BaseEntity {
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "created_by", nullable = false, updatable = false)
    @CreatedBy
    private String createdBy = "SYSTEM";

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @LastModifiedBy
    @Column(name = "updated_by", nullable = false, insertable = false)
    private String updatedBy = "SYSTEM";
}