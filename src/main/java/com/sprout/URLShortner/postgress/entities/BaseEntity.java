package com.sprout.URLShortner.postgress.entities;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseEntity {

    @Column(name = "createdBy", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
