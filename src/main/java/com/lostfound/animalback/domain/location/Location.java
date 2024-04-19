package com.lostfound.animalback.domain.location;

import com.lostfound.animalback.domain.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "location", schema = "animal")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @NotNull
    @Column(name = "location_name", nullable = false)
    private Integer locationName;

    @NotNull
    @Column(name = "latitude", nullable = false, precision = 14, scale = 12)
    private BigDecimal latitude;

    @NotNull
    @Column(name = "longitude", nullable = false, precision = 14, scale = 12)
    private BigDecimal longitude;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Size(max = 255)
    @NotNull
    @Column(name = "comment", nullable = false)
    private String comment;

}