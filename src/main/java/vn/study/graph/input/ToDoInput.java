package vn.study.graph.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ToDoInput {
    private  String title;
    private String startDate;
    private String endDate;
    private String description;
    private Long categoryId;
}
