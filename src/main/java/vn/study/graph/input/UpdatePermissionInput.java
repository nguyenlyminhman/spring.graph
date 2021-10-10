package vn.study.graph.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdatePermissionInput {
    private Long id;
    private String name;
    private String description;
}
