package com.hardwarestore.items.services;

import com.hardwarestore.entities.filters.ItemFilter;
import com.hardwarestore.entities.items.Item;
import com.hardwarestore.repositories.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends AbstractItemService<Item, ItemFilter> {

    ItemService(@Autowired ItemRepository itemRepository) {
        super(itemRepository);
    }
}
