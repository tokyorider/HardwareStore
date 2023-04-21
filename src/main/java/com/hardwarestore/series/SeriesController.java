package com.hardwarestore.series;

import com.hardwarestore.entities.Series;
import com.hardwarestore.entities.items.Item;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
@Tag(name = "Линейка техники", description = "API для работы с линейками техники")
public class SeriesController {

    private final SeriesService seriesService;

    @GetMapping
    @Operation(summary = "Получение информации обо всех существующих линейках техники")
    public List<Series> getAll() {
        return seriesService.getAll();
    }

    @PostMapping
    @Operation(summary = "Добавление новой линейки техники")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "400")})
    public void add(@RequestBody Series series) {
        seriesService.add(series);
    }

    @GetMapping("/{id}/items")
    @Operation(summary = "Получение всех единиц техники для заданной линейки")
    public List<Item> getAllItems(@PathVariable("id") int seriesId) {
        return seriesService.getAllItems(seriesId);
    }
}
