package com.hardwarestore.repositories.items;

import com.hardwarestore.entities.filters.ItemFilter;
import com.hardwarestore.entities.items.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface AbstractItemRepository <T extends Item, F extends ItemFilter> extends JpaRepository<T, Integer> {

    List<T> findByTitleContainingIgnoreCase(String title);

    List<T> filter(F filter);
}
