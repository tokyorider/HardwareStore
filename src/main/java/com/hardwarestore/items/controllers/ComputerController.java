package com.hardwarestore.items.controllers;

import com.hardwarestore.entities.dtos.ComputerDto;
import com.hardwarestore.entities.filters.ComputerFilter;
import com.hardwarestore.entities.items.Computer;
import com.hardwarestore.items.services.ComputerService;
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
@RequestMapping("/items/computers")
@Tag(name = "Компьютер", description = "API для работы с реестром компьютеров")
public class ComputerController extends AbstractItemController<Computer, ComputerFilter> {

    ComputerController(@Autowired ComputerService computerService) {
        super(computerService);
    }

    @PostMapping
    @Operation(summary = "Добавление компьютера в реестр техники")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "400")})
    public void add(@RequestBody ComputerDto dto) {
        service.add(dto.toEntity(), dto.getSeriesId());
    }
}
