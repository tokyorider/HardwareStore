package com.hardwarestore.items.services;

import com.hardwarestore.entities.filters.SmartphoneFilter;
import com.hardwarestore.entities.items.Smartphone;
import com.hardwarestore.repositories.items.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneService extends AbstractItemService<Smartphone, SmartphoneFilter> {

    SmartphoneService(@Autowired SmartphoneRepository smartphoneRepository) {
        super(smartphoneRepository);
    }
}
