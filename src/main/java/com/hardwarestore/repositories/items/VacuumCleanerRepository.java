package com.hardwarestore.repositories.items;

import com.hardwarestore.entities.filters.VacuumCleanerFilter;
import com.hardwarestore.entities.items.VacuumCleaner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacuumCleanerRepository extends AbstractItemRepository<VacuumCleaner, VacuumCleanerFilter> {

    @Query("select vc from VacuumCleaner vc " +
            "where (:#{#filter.color} is null or :#{#filter.color} = lower(vc.color)) " +
            "and (:#{#filter.minPrice} is null or :#{#filter.minPrice} <= vc.price) " +
            "and (:#{#filter.maxPrice} is null or :#{#filter.maxPrice} >= vc.price) " +
            "and (:#{#filter.minDustContainerVolume} is null or :#{#filter.minDustContainerVolume} <= vc.dustContainerVolume) " +
            "and (:#{#filter.maxDustContainerVolume} is null or :#{#filter.maxDustContainerVolume} >= vc.dustContainerVolume) " +
            "and (:#{#filter.modesAmount} is null or :#{#filter.modesAmount} = vc.modesAmount) " +
            "order by vc.title")
    List<VacuumCleaner> filter(@Param("filter") VacuumCleanerFilter filter);
}
