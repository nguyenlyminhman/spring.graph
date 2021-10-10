package vn.study.graph.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.study.graph.contracts.mutations.PermissionMutationContract;
import vn.study.graph.contracts.queries.PermissionQueryContract;
import vn.study.graph.entities.Permission;
import vn.study.graph.input.CreatePermissionInput;
import vn.study.graph.input.UpdatePermissionInput;
import vn.study.graph.repositories.PermissionRepository;

import java.util.List;

@Service
@Transactional
public class PermissionService implements PermissionMutationContract, PermissionQueryContract {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission createPermission(CreatePermissionInput input) {
        return null;
    }

    @Override
    public Permission updatePermissionInfo(UpdatePermissionInput input) {
        return null;
    }

    @Override
    public Permission updatePermissionStatusById(UpdatePermissionInput input) {
        return null;
    }

    @Override
    public List<Permission> getAllPermission() {
        return null;
    }

    @Override
    public Permission getPermissionById(Long id) {
        return null;
    }
}
