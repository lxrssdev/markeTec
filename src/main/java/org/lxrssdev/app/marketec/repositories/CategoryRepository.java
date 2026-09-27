package org.lxrssdev.app.marketec.repositories;

import org.lxrssdev.app.marketec.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Long, Category> {
}
