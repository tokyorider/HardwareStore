package com.hardwarestore.items.services;

import com.hardwarestore.entities.filters.TVFilter;
import com.hardwarestore.entities.items.TV;
import com.hardwarestore.repositories.items.TVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TVService extends AbstractItemService<TV, TVFilter> {

    TVService(@Autowired TVRepository tvRepository) {
        super(tvRepository);
    }
}
