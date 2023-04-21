package com.hardwarestore.series;

import com.hardwarestore.entities.Series;
import com.hardwarestore.entities.items.Item;
import com.hardwarestore.repositories.SeriesRepository;
import com.hardwarestore.repositories.items.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesService {

    private final SeriesRepository seriesRepository;

    private final ItemRepository itemRepository;

    public List<Series> getAll() {
        return seriesRepository.findAll();
    }

    public void add(Series series) {
        seriesRepository.save(series);
    }

    public List<Item> getAllItems(int seriesId) {
        Series series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new IllegalArgumentException("Линейки товаров с таким id не существует"));
        return itemRepository.findAllBySeries(series);
    }
}
