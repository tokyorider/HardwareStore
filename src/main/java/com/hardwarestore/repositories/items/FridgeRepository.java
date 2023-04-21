package com.hardwarestore.repositories.items;

import com.hardwarestore.entities.filters.FridgeFilter;
import com.hardwarestore.entities.items.Fridge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository extends AbstractItemRepository<Fridge, FridgeFilter> {

    @Query("select f from Fridge f " +
            "where (:#{#filter.color} is null or :#{#filter.color} = lower(f.color)) " +
            "and (:#{#filter.minPrice} is null or :#{#filter.minPrice} <= f.price) " +
            "and (:#{#filter.maxPrice} is null or :#{#filter.maxPrice} >= f.price) " +
            "and (:#{#filter.doorsAmount} is null or :#{#filter.doorsAmount} = f.doorsAmount) " +
            "and (:#{#filter.compressorType} is null or :#{#filter.compressorType} = f.compressorType) " +
            "order by f.title")
    List<Fridge> filter(@Param("filter") FridgeFilter filter);
}
