package vn.study.graph.resolvers.queries;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.study.graph.contracts.queries.PermissionQueryContract;
import vn.study.graph.entities.Permission;

import java.util.List;

@Component
public class PermissionQuery implements GraphQLQueryResolver {

    @Autowired
    private PermissionQueryContract permissionQueryContract;

    List<Permission> getAllPermission(){
        return permissionQueryContract.getAllPermission();
    }

    Permission getPermissionById(Long id){
        return permissionQueryContract.getPermissionById(id);
    }
}
