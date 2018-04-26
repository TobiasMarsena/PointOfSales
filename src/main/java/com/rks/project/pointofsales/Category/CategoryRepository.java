package com.rks.project.pointofsales.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 26/04/2018.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
