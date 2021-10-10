package vn.study.graph.resolvers.mutations;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.study.graph.contracts.mutations.PermissionMutationContract;
import vn.study.graph.entities.Permission;
import vn.study.graph.input.CreatePermissionInput;
import vn.study.graph.input.UpdatePermissionInput;

@Component
public class PermissionMutation implements GraphQLMutationResolver {

    @Autowired
    private PermissionMutationContract permissionMutationContract;

    Permission createPermission(CreatePermissionInput input){
        return permissionMutationContract.createPermission(input);
    }

    Permission updatePermissionInfo(UpdatePermissionInput input){
        return permissionMutationContract.updatePermissionInfo(input);
    }

    Permission activePermissionStatusById(UpdatePermissionInput input){
        return permissionMutationContract.activePermissionStatusById(input);
    }

    Permission deactivePermissionStatusById(UpdatePermissionInput input){
        return permissionMutationContract.deactivePermissionStatusById(input);
    }
}
