package org.example.services;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.example.models.Todo;
import org.example.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodoById(@Valid @NotNull Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
    }

    @Transactional
    public Todo updateTodo(@Valid @NotNull Long id, String todo, boolean completed, int userId) {
        Todo todoObject = getTodoById(id);
        todoObject.setTodo(todo);
        todoObject.setCompleted(completed);
        todoObject.setUserId(userId);
        return todoRepository.save(todoObject);
    }

    public void deleteTodo(@Valid @NotNull Long id) {
        Todo todo = getTodoById(id);
        todoRepository.delete(todo);
    }
}