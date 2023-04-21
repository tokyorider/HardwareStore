package com.hardwarestore.items.controllers;

import com.hardwarestore.entities.dtos.VacuumCleanerDto;
import com.hardwarestore.entities.filters.VacuumCleanerFilter;
import com.hardwarestore.entities.items.VacuumCleaner;
import com.hardwarestore.items.services.VacuumCleanerService;
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
@RequestMapping("/items/vacuum-cleaners")
@Tag(name = "Пылесос", description = "API для работы с реестром пылесосов")
public class VacuumCleanerController extends AbstractItemController<VacuumCleaner, VacuumCleanerFilter> {

    VacuumCleanerController(@Autowired VacuumCleanerService vacuumCleanerService) {
        super(vacuumCleanerService);
    }

    @PostMapping
    @Operation(summary = "Добавление пылесоса в реестр техники")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "400")})
    public void add(@RequestBody VacuumCleanerDto dto) {
        service.add(dto.toEntity(), dto.getSeriesId());
    }
}
