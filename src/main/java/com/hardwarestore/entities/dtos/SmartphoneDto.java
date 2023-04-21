package com.hardwarestore.entities.dtos;

import com.hardwarestore.entities.items.Smartphone;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class SmartphoneDto extends ItemDto {

    //В гигабайтах
    private Integer memory;

    private Integer camsAmount;

    @Override
    public Smartphone toEntity() {
        return Smartphone.builder()
                .title(title)
                .serialNumber(serialNumber)
                .color(color)
                .price(BigDecimal.valueOf(price))
                .length(length)
                .width(width)
                .depth(depth)
                .isAvailable(isAvailable)
                .camsAmount(camsAmount)
                .memory(memory)
                .build();
    }
}
