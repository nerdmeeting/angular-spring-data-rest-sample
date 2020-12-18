package org.guylabs.angular.spring.data.rest.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class JpaApplicationWriter implements ApplicationRunner {

    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;

    @Override
    public void run(ApplicationArguments args) {

        if (categoryRepository.count() != 0) {
            return;
        }

        // create some categories
        Category firstCategory = categoryRepository.save(Category.from("Parent Category 1", null, new ArrayList<>()));
        categoryRepository.save(Category.from("Child Category 1", firstCategory, new ArrayList<>()));
        categoryRepository.save(Category.from("Child Category 2", firstCategory, new ArrayList<>()));
        categoryRepository.save(Category.from("Parent Category 2", null, new ArrayList<>()));

        Category secondCategory = categoryRepository.save(Category.from("Parent Category 3", null, new ArrayList<>()));
        categoryRepository.save(Category.from("Child Category 3", secondCategory, new ArrayList<>()));
        categoryRepository.save(Category.from("Child Category 4", secondCategory, new ArrayList<>()));
        categoryRepository.save(Category.from("Child Category 5", secondCategory, new ArrayList<>()));

        // create some items
        itemRepository.save(Item.from("Item 1", null));
        itemRepository.save(Item.from("Item 2", firstCategory));
        itemRepository.save(Item.from("Item 3", firstCategory));
        itemRepository.save(Item.from("Item 4", secondCategory));
        itemRepository.save(Item.from("Item 5", secondCategory));
        itemRepository.save(Item.from("Item 6", secondCategory));
    }
}
