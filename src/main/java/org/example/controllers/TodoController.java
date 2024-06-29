package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.repo.TodoRepository;
import org.example.models.Todo;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@Tag(name = "Todo Controller", description = "CRUD operations for todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    @Operation(summary = "Get all todos", description = "Retrieves a list of all todos")
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new todo", description = "Creates a new todo item")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a todo by ID", description = "Retrieves a todo by its ID")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a todo", description = "Updates an existing todo by its ID")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

        todo.setTitle(todoDetails.getTitle());
        todo.setCompleted(todoDetails.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a todo", description = "Deletes a todo by its ID")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

        todoRepository.delete(todo);
        return ResponseEntity.ok().build();
    }
}
