package com.hardwarestore.items.controllers;

import com.hardwarestore.entities.dtos.FridgeDto;
import com.hardwarestore.entities.filters.FridgeFilter;
import com.hardwarestore.entities.items.Fridge;
import com.hardwarestore.items.services.FridgeService;
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
@RequestMapping("/items/fridges")
@Tag(name = "Холодильник", description = "API для работы с реестром холодильников")
public class FridgeController extends AbstractItemController<Fridge, FridgeFilter> {

    FridgeController(@Autowired FridgeService fridgeService) {
        super(fridgeService);
    }

    @PostMapping
    @Operation(summary = "Добавление холодильника в реестр техники")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "400")})
    public void add(@RequestBody FridgeDto dto) {
        service.add(dto.toEntity(), dto.getSeriesId());
    }
}
