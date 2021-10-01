package vn.study.graph.input;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class CategoryInput {

    @NotEmpty(message="Name is required")
    private String name;
    private String description;
}
