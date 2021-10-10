package vn.study.graph.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.study.graph.entities.Permission;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Modifying
    @Query(value = "Update permissions SET name=?2, description=?3 where id=?1", nativeQuery = true)
    int updatePermissionInfo(Long id, String name, String desc );

    @Query(value = "Select * from permissions where name=?1", nativeQuery = true)
    Optional<Permission> checkPermissionName(String name);

}
