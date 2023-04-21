package com.hardwarestore.items.controllers;

import com.hardwarestore.entities.filters.ItemFilter;
import com.hardwarestore.entities.items.Item;
import com.hardwarestore.items.services.AbstractItemService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractItemController <T extends Item, F extends ItemFilter> {

    protected final AbstractItemService<T, F> service;

    @GetMapping
    @Operation(summary = "Получение информации обо всех товарах, название которых содержит заданную строку")
    public List<T> getByTitle(@RequestParam String title) {
        return service.getByTitle(title);
    }

    @GetMapping("/filter")
    @Operation(summary = "Фильтрация списка товаров, как в зависимости от типа, так и по всему списку",
                description = "Результат фильтрации отсортирован по алфавиту.")
    public List<T> filter(@RequestBody F filter) {
        return service.filter(filter);
    }

    @GetMapping("/sort-by-price")
    @Operation(summary = "Получение списка всех товаров, отсортированнх по возрастанию цены")
    public List<T> sortByPrice() {
        return service.sortByPrice();
    }
}
