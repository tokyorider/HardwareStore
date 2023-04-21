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
@Table(name = "fridges")
@EqualsAndHashCode(callSuper = true)
public class Fridge extends Item {

    private int doorsAmount;

    private String compressorType;
}
