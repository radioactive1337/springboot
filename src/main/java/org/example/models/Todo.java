package org.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Getter
@Setter
@Schema(description = "Todo item")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "The unique identifier of the todo")
    private Long id;

    @Schema(description = "The title of the todo")
    private String title;

    @Schema(description = "The completion status of the todo")
    private boolean completed;

}