package com.rks.project.pointofsales.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 26/04/2018.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
