package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.models.Todo;
import org.example.services.OuterTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/outer/todos")
@Tag(name = "Todo from outer service")
public class OuterTodoController {

    private final OuterTodoService outerTodoService;

    @Autowired
    public OuterTodoController(OuterTodoService outerTodoService) {
        this.outerTodoService = outerTodoService;
    }

    @GetMapping
    @Operation(summary = "Get all todos")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<Todo> getAllTodos() {
        return outerTodoService.getAllTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a todo by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public Todo getTodoById(@PathVariable Long id) {
        return outerTodoService.getTodoById(id);
    }

    @GetMapping(value = "/count")
    @Operation(summary = "Get number of all todos")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<Map<String, Integer>> getCount() {
        int count = outerTodoService.getCount();
        Map<String, Integer> response = Collections.singletonMap("count", count);
        return ResponseEntity.ok(response);
    }
}
