package ru.outletproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.outletproject.model.Restaurant;
import ru.outletproject.repository.datajpa.DataJpaRestaurantRepositoryImpl;
import ru.outletproject.to.RestaurantTo;
import ru.outletproject.util.exception.ExceptionUtil;
import ru.outletproject.util.exception.NotFoundException;

import java.util.List;
import java.util.Objects;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private DataJpaRestaurantRepositoryImpl repository;

    @CacheEvict(value = "restaurants", allEntries = true)
    @Override
    public Restaurant save(Restaurant restaurant) {
        Objects.requireNonNull(restaurant);
        return repository.save(restaurant);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    @Override
    public void update(RestaurantTo restaurantTo) {
        Objects.requireNonNull(restaurantTo);
        Restaurant newRestaurant = get(restaurantTo.getId());
        repository.save(newRestaurant);
    }

    @Cacheable("restaurants")
    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    @Override
    public void update(Restaurant restaurant) {
        Objects.requireNonNull(restaurant);
        repository.save(restaurant);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    @Override
    public void evictCache() {
    }

    @Override
    public Restaurant getWithDishes(int id) {
        return ExceptionUtil.check(repository.getWithDishes(id), id);
    }
}
