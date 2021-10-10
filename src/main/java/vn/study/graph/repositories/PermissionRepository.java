package vn.study.graph.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.study.graph.entities.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

//    @Query(value = "Update permissions set name=?2, description=?3 where id=?1", nativeQuery = true)
//    Permission updatePermissionInfo(Long id, String name, String desc );
//
//    @Query(value = "Update permissions set active=false where id=?1", nativeQuery = true)
//    Permission updatePermissionStatus(Long id);

}
