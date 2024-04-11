package com.lostfound.animalback.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "animal_image", schema = "animal")
public class AnimalImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @NotNull
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

}