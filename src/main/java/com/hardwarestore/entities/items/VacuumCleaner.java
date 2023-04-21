package com.hardwarestore.entities.items;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VacuumCleaners")
@EqualsAndHashCode(callSuper = true)
public class VacuumCleaner extends Item {

    //В литрах
    private float dustContainerVolume;

    private int modesAmount;
}
