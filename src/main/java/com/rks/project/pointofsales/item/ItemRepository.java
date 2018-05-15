package com.rks.project.pointofsales.item;

import com.rks.project.pointofsales.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

/**
 * Created by ASUS on 26/04/2018.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByName(String name);
    List<Item> findByCategory(Category category);

}
