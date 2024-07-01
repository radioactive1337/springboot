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
    private Long id;
    private String todo;
    private boolean completed;
    private int userId;

}