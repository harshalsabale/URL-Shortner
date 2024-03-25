package com.sprout.URLShortner.postgress.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Table(name = "link_mapping")
@NoArgsConstructor
@Getter
@Setter
public class LinkMappingEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(
            name = "sequence",
            initialValue = 1000000000
    )
    private Long uniqueId;

    @Column(name = "keyUrl", length = 7, unique = true)
    private String key;

    @Column(name = "valueUrl", nullable = false, updatable = false)
    private String value;
}
