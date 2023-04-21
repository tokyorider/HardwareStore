package com.hardwarestore.items.controllers;

import com.hardwarestore.entities.dtos.SmartphoneDto;
import com.hardwarestore.entities.filters.SmartphoneFilter;
import com.hardwarestore.entities.items.Smartphone;
import com.hardwarestore.items.services.SmartphoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items/smartphones")
@Tag(name = "Смартфон", description = "API для работы с реестром смартфонов")
public class SmartphoneController extends AbstractItemController<Smartphone, SmartphoneFilter> {

    public SmartphoneController(@Autowired SmartphoneService smartphoneService) {
        super(smartphoneService);
    }

    @PostMapping
    @Operation(summary = "Добавление смартфона в реестр техники")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "400")})
    public void add(@RequestBody SmartphoneDto dto) {
        service.add(dto.toEntity(), dto.getSeriesId());
    }
}
