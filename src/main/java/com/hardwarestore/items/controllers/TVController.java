package com.hardwarestore.items.controllers;

import com.hardwarestore.entities.dtos.TVDto;
import com.hardwarestore.entities.filters.TVFilter;
import com.hardwarestore.entities.items.TV;
import com.hardwarestore.items.services.TVService;
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
@RequestMapping("/items/tvs")
@Tag(name = "Телевизор", description = "API для работы с реестром телевизоров")
public class TVController extends AbstractItemController<TV, TVFilter> {

    TVController(@Autowired TVService tvService) {
        super(tvService);
    }

    @PostMapping
    @Operation(summary = "Добавление телевизора в реестр техники")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "400")})
    public void add(@RequestBody TVDto dto) {
        service.add(dto.toEntity(), dto.getSeriesId());
    }
}
