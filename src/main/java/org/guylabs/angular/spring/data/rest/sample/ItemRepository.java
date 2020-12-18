package org.guylabs.angular.spring.data.rest.sample;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Default {@link org.guylabs.angular.spring.data.rest.sample.Item} repository.
 */
@RepositoryRestResource(itemResourceDescription = @Description(
        value = "Item repository"))
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {}