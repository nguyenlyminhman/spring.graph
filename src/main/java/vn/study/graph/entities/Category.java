package vn.study.graph.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @SequenceGenerator(name = "graphql_categories_seq", sequenceName = "graphql_categories_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "graphql_categories_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

}
