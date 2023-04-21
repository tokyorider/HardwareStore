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
@Table(name="smartphones")
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Item {

    //В гигабайтах
    private int memory;

    private int camsAmount;
}
