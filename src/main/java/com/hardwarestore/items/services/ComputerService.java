package com.hardwarestore.items.services;

import com.hardwarestore.entities.filters.ComputerFilter;
import com.hardwarestore.entities.items.Computer;
import com.hardwarestore.repositories.items.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerService extends AbstractItemService<Computer, ComputerFilter> {

    ComputerService(@Autowired ComputerRepository computerRepository) {
        super(computerRepository);
    }
}
