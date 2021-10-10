package vn.study.graph.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.study.graph.contracts.mutations.PermissionMutationContract;
import vn.study.graph.contracts.queries.PermissionQueryContract;
import vn.study.graph.entities.Permission;
import vn.study.graph.exception_handlers.EntityException;
import vn.study.graph.input.CreatePermissionInput;
import vn.study.graph.input.UpdatePermissionInput;
import vn.study.graph.repositories.PermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermissionService implements PermissionMutationContract, PermissionQueryContract {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission createPermission(CreatePermissionInput input) {
        String name = input.getName();
        Optional<Permission> permission = permissionRepository.checkPermissionName(name);
        if(permission.isPresent())
            throw new EntityException("Permission existed", name);
        Permission newPermission = new Permission();
        newPermission.setName(input.getName());
        newPermission.setDescription(input.getDescription());
        newPermission.setActive(true);
        permissionRepository.save(newPermission);
        return newPermission;
    }

    @Override
    public Permission updatePermissionInfo(UpdatePermissionInput input) {
        Long id = input.getId();
        Optional<Permission> permission = permissionRepository.findById(id);
        if(!permission.isPresent())
            throw new EntityException("Permission not found", "Id");

        Permission permissionInfo = permission.get();
        permissionInfo.setName(input.getName());
        permissionInfo.setDescription(input.getDescription());
//       int a = permissionRepository.updatePermissionInfo( id, input.getName(), input.getDescription());
       return permissionInfo;
    }

    @Override
    public Permission activePermissionStatusById(UpdatePermissionInput input) {
        Optional<Permission> permission = permissionRepository.findById(input.getId());
        if(!permission.isPresent())
            throw new EntityException("Id not found", "Id");
        Permission activePermission = permission.get();
        activePermission.setActive(true);
        permissionRepository.save(activePermission);
        return activePermission;
    }

    @Override
    public Permission deactivePermissionStatusById(UpdatePermissionInput input) {
        Optional<Permission> permission = permissionRepository.findById(input.getId());
        if(!permission.isPresent())
            throw new EntityException("Id not found", "Id");

        Permission deactivePermission = permission.get();
        deactivePermission.setActive(false);
        permissionRepository.save(deactivePermission);
        return deactivePermission;
    }

    @Override
    public List<Permission> getAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getPermissionById(Long id) {
        Optional<Permission> permissions = permissionRepository.findById(id);
        if(!permissions.isPresent())
            throw new EntityException("Permission not found", id);
        return permissions.get();
    }
}
