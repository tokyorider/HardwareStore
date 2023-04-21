package com.hardwarestore.entities.dtos;

import com.hardwarestore.entities.items.Computer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ComputerDto extends ItemDto {

    private String type;

    private String cpuType;

    @Override
    public Computer toEntity() {
        return Computer.builder()
                .title(title)
                .serialNumber(serialNumber)
                .color(color)
                .price(BigDecimal.valueOf(price))
                .length(length)
                .width(width)
                .depth(depth)
                .isAvailable(isAvailable)
                .type(type)
                .cpuType(cpuType)
                .build();
    }
}
