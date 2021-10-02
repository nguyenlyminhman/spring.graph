package vn.study.graph.entities;


import lombok.Data;
import vn.study.graph.enums.ToDoStatus;

import javax.persistence.*;

@Data
@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @SequenceGenerator(name = "graphl_todo_seq", sequenceName = "graphl_todo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "graphl_todo_seq")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ToDoStatus status = ToDoStatus.CREATED;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "completed_date")
    private String completedDate;

    @Column(name = "completed")
    private Boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
