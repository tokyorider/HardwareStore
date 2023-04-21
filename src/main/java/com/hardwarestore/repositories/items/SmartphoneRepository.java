package com.hardwarestore.repositories.items;

import com.hardwarestore.entities.filters.SmartphoneFilter;
import com.hardwarestore.entities.items.Smartphone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartphoneRepository extends AbstractItemRepository<Smartphone, SmartphoneFilter> {

    @Query("select s from Smartphone s " +
            "where (:#{#filter.color} is null or :#{#filter.color} = lower(s.color)) " +
            "and (:#{#filter.minPrice} is null or :#{#filter.minPrice} <= s.price) " +
            "and (:#{#filter.maxPrice} is null or :#{#filter.maxPrice} >= s.price) " +
            "and (:#{#filter.minMemory} is null or :#{#filter.minMemory} <= s.memory) " +
            "and (:#{#filter.maxMemory} is null or :#{#filter.maxMemory} >= s.memory) " +
            "and (:#{#filter.camsAmount} is null or :#{#filter.camsAmount} = s.camsAmount) " +
            "order by s.title")
    List<Smartphone> filter(@Param("filter") SmartphoneFilter filter);
}
