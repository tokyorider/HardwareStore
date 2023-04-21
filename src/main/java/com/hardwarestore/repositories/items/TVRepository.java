package com.hardwarestore.repositories.items;

import com.hardwarestore.entities.filters.TVFilter;
import com.hardwarestore.entities.items.TV;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TVRepository extends AbstractItemRepository<TV, TVFilter> {

    @Query("select tv from TV tv " +
            "where (:#{#filter.color} is null or :#{#filter.color} = lower(tv.color)) " +
            "and (:#{#filter.minPrice} is null or :#{#filter.minPrice} <= tv.price) " +
            "and (:#{#filter.maxPrice} is null or :#{#filter.maxPrice} >= tv.price) " +
            "and (:#{#filter.type} is null or :#{#filter.type} = tv.type) " +
            "and (:#{#filter.technology} is null or :#{#filter.technology} = tv.technology)" +
            "order by tv.title")
    List<TV> filter(@Param("filter") TVFilter filter);
}
