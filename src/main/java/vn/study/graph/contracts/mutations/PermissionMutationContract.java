package vn.study.graph.contracts.mutations;

import vn.study.graph.entities.Permission;
import vn.study.graph.input.CreatePermissionInput;
import vn.study.graph.input.UpdatePermissionInput;

public interface PermissionMutationContract {
    Permission createPermission(CreatePermissionInput input);
    Permission updatePermissionInfo(UpdatePermissionInput input);
    Permission activePermissionStatusById(UpdatePermissionInput input);
    Permission deactivePermissionStatusById(UpdatePermissionInput input);
}
