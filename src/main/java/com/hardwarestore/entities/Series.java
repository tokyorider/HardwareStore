package com.hardwarestore.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String originCountry;

    @NotNull
    private String manufacturerCompany;

    @NotNull
    private Boolean isOnlineOrderAvailable;

    @NotNull
    private Boolean isInstallmentPlanAvailable;
}
