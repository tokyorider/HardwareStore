package com.hardwarestore.items.services;

import com.hardwarestore.entities.filters.FridgeFilter;
import com.hardwarestore.entities.items.Fridge;
import com.hardwarestore.repositories.items.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FridgeService extends AbstractItemService<Fridge, FridgeFilter> {

    FridgeService(@Autowired FridgeRepository fridgeRepository) {
        super(fridgeRepository);
    }
}
