package com.hardwarestore.repositories.items;

import com.hardwarestore.entities.filters.ComputerFilter;
import com.hardwarestore.entities.items.Computer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends AbstractItemRepository<Computer, ComputerFilter> {

    @Query("select c from Computer c " +
            "where (:#{#filter.color} is null or :#{#filter.color} = lower(c.color)) " +
            "and (:#{#filter.minPrice} is null or :#{#filter.minPrice} <= c.price) " +
            "and (:#{#filter.maxPrice} is null or :#{#filter.maxPrice} >= c.price) " +
            "and (:#{#filter.type} is null or :#{#filter.type} = c.type) " +
            "and (:#{#filter.cpuType} is null or :#{#filter.cpuType} = c.cpuType) " +
            "order by c.title")
    List<Computer> filter(@Param("filter") ComputerFilter filter);
}
