package vn.study.graph.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import vn.study.graph.entities.Category;
import vn.study.graph.entities.Users;
import vn.study.graph.enums.ToDoStatus;

@Data
@Setter
@Getter
@AllArgsConstructor
public class ToDoInput {
    private  String title;
    private ToDoStatus status;
    private String startDate;
    private String endDate;
    private String description;
    private Long categoryId;
    private Long userId;
}
