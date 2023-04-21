package com.hardwarestore.items.services;

import com.hardwarestore.entities.filters.VacuumCleanerFilter;
import com.hardwarestore.entities.items.VacuumCleaner;
import com.hardwarestore.repositories.items.VacuumCleanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacuumCleanerService extends AbstractItemService<VacuumCleaner, VacuumCleanerFilter> {

    VacuumCleanerService(@Autowired VacuumCleanerRepository vacuumCleanerRepository) {
        super(vacuumCleanerRepository);
    }
}
