package com.hardwarestore.entities.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hardwarestore.entities.Series;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="series_id")
    private Series series;

    private String title;

    private String serialNumber;

    private String color;

    //В российских рублях
    private BigDecimal price;

    //Все три измерения в миллиметрах
    private float length;

    private float width;

    private float depth;

    private boolean isAvailable;
}
