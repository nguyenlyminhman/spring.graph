package vn.study.graph.contracts.queries;

import vn.study.graph.entities.Permission;

import java.util.List;

public interface PermissionQueryContract {
    List<Permission> getAllPermission();
    Permission getPermissionById(Long id);
}
