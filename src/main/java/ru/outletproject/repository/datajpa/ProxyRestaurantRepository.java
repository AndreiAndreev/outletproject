package ru.outletproject.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.outletproject.model.Restaurant;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Restaurant save(Restaurant restaurant);

    @Override
    Restaurant findOne(Integer id);

    @Override
    List<Restaurant> findAll();

    Restaurant findByName(String name);

    @Transactional
    @Query("UPDATE Restaurant r SET r.votes = r.votes + 1 WHERE r.id=:id")
    int vote(@Param("id") int id);

    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.menu WHERE r.id=:id")
    Restaurant getWithDishes(@Param("id") int id);

}
