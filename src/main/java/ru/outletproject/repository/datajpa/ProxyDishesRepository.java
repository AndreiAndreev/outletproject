package ru.outletproject.repository.datajpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.outletproject.model.Dish;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyDishesRepository extends JpaRepository<Dish, Integer>{

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.restaurant.id=:restaurantId AND d.id=:dishId")
    int delete(@Param("restaurantId") int restaurantId, @Param("dishId") int dishId);

    @Override
    Dish save(Dish dish);

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id=:restaurantId AND d.id=:dishId")
    Dish findOne(@Param("restaurantId") int restaurantId, @Param("dishId") int dishId);

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id=:restaurantId")
    List<Dish> findAll(@Param("restaurantId") int restaurantId);

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.restaurant.id=:restaurantId AND d.id=:dishId")
    Dish getWithRestaurant(@Param("restaurantId") int restaurantId, @Param("dishId") int dishId);

}
