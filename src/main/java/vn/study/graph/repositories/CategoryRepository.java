package vn.study.graph.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.study.graph.entities.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{

    @Query(value = "Select * from categories c where c.name=?1", nativeQuery = true)
    Optional<Category> checkExistName(String name);

    @Query(value = "Select * from categories c where c.id=?1", nativeQuery = true)
    Optional<Category> checkExistName(Long id);

    @Modifying
    @Query(value = "Update categories c SET c.active=false where c.id=?1", nativeQuery = true)
    Optional<Category> deleteCategory(Long id);

    @Modifying
    @Query(value = "Update categories c SET c.name=?1, c.description=?2 where c.id=?3", nativeQuery = true)
    Optional<Category> updateCategory(String name, String desc, Long id);
}
