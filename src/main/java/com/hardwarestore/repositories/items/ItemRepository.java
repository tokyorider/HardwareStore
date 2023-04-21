package com.hardwarestore.repositories.items;

import com.hardwarestore.entities.Series;
import com.hardwarestore.entities.filters.ItemFilter;
import com.hardwarestore.entities.items.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends AbstractItemRepository<Item, ItemFilter> {

    @Query("select i from Item i " +
            "where (:#{#filter.color} is null or :#{#filter.color} = lower(i.color)) " +
            "and (:#{#filter.minPrice} is null or :#{#filter.minPrice} <= i.price) " +
            "and (:#{#filter.maxPrice} is null or :#{#filter.maxPrice} >= i.price) " +
            "order by i.title")
    List<Item> filter(@Param("filter") ItemFilter filter);

    List<Item> findAllBySeries(Series series);
}
