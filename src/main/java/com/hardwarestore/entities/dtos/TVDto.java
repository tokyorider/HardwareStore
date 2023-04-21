package com.hardwarestore.entities.dtos;

import com.hardwarestore.entities.items.TV;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class TVDto extends ItemDto {

    private String type;

    private String technology;

    @Override
    public TV toEntity() {
        return TV.builder()
                .title(title)
                .serialNumber(serialNumber)
                .color(color)
                .price(BigDecimal.valueOf(price))
                .length(length)
                .width(width)
                .depth(depth)
                .isAvailable(isAvailable)
                .type(type)
                .technology(technology)
                .build();
    }
}
