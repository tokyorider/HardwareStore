package com.hardwarestore.entities.dtos;

import com.hardwarestore.entities.items.VacuumCleaner;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class VacuumCleanerDto extends ItemDto {

    //В литрах
    private Float dustContainerVolume;

    private Integer modesAmount;

    @Override
    public VacuumCleaner toEntity() {
        return VacuumCleaner.builder()
                .title(title)
                .serialNumber(serialNumber)
                .color(color)
                .price(BigDecimal.valueOf(price))
                .length(length)
                .width(width)
                .depth(depth)
                .isAvailable(isAvailable)
                .dustContainerVolume(dustContainerVolume)
                .modesAmount(modesAmount)
                .build();
    }
}
