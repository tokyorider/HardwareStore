package com.hardwarestore.items.services;

import com.hardwarestore.entities.Series;
import com.hardwarestore.entities.filters.ItemFilter;
import com.hardwarestore.entities.items.Item;
import com.hardwarestore.repositories.SeriesRepository;
import com.hardwarestore.repositories.items.AbstractItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Objects;

public abstract class AbstractItemService <T extends Item, F extends ItemFilter> {

    protected final AbstractItemRepository<T, F> itemRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    protected AbstractItemService(AbstractItemRepository<T, F> itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<T> getByTitle(String title) {
        return itemRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<T> filter(F filter) {

        if (Objects.nonNull(filter.color)) {

            filter.color = filter.color.toLowerCase();
        }

        return itemRepository.filter(filter);
    }

    public List<T> sortByPrice() {
        return itemRepository.findAll(Sort.by("price"));
    }

    public void add(T item, int seriesId) {
        Series series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new IllegalArgumentException("Линейки товаров с таким id не существует"));
        item.setSeries(series);
        itemRepository.save(item);
    }
}
