package com.hardwarestore.entities.dtos;

import com.hardwarestore.entities.items.Item;
import lombok.Data;

@Data
public abstract class ItemDto {

    protected Integer seriesId;

    protected String title;

    protected String serialNumber;

    protected String color;

    //В российских рублях
    protected Float price;

    //Все три измерения в миллиметрах
    protected Float length;

    protected Float width;

    protected Float depth;

    protected Boolean isAvailable;

    public abstract Item toEntity();
}
