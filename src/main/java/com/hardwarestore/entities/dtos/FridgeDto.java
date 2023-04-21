package com.hardwarestore.entities.dtos;

import com.hardwarestore.entities.items.Fridge;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class FridgeDto extends ItemDto {

    private Integer doorsAmount;

    private String compressorType;

    @Override
    public Fridge toEntity() {
        return Fridge.builder()
                .title(title)
                .serialNumber(serialNumber)
                .color(color)
                .price(BigDecimal.valueOf(price))
                .length(length)
                .width(width)
                .depth(depth)
                .isAvailable(isAvailable)
                .doorsAmount(doorsAmount)
                .compressorType(compressorType)
                .build();
    }
}
