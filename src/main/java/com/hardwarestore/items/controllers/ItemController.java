package com.hardwarestore.items.controllers;

import com.hardwarestore.entities.filters.ItemFilter;
import com.hardwarestore.entities.items.Item;
import com.hardwarestore.items.services.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@Tag(name = "Единица техники", description = "API для работы с регистром техники всех видов")
public class ItemController extends AbstractItemController<Item, ItemFilter> {

    public ItemController(@Autowired ItemService itemService) {
        super(itemService);
    }
}
