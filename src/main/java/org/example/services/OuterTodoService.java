package org.example.services;

import org.example.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class OuterTodoService {

    private final String BASE_URL = "https://dummyjson.com/todos";
    private final RestTemplate restTemplate;

    @Autowired
    public OuterTodoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Todo> getAllTodos() {
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>() {
                }
        );

        Map<String, Object> body = response.getBody();
        return (List<Todo>) body.get("todos");
    }

    public Todo getTodoById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Todo.class);
    }

    public int getCount() {
        return getAllTodos().size();
    }

}
