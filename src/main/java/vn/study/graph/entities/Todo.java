package vn.study.graph.entities;


import lombok.Data;
import vn.study.graph.enums.ToDoStatus;

import javax.persistence.*;

@Data
@Entity
@Table(name = "todo_list")
public class Todo {
    @Id
    @SequenceGenerator(name = "graphql_todo_list_seq", sequenceName = "graphql_todo_list_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "graphql_todo_list_seq")
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users createdBy;

}
