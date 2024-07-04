package org.example.services;

import org.example.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class OuterTodoService {

//    private final String BASE_URL = "https://dummyjson.com/todos";
    private final WebClient webClient;

    @Autowired
    public OuterTodoService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public List<Todo> getAllTodos() {
        return webClient.get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .map(response -> (List<Todo>) response.get("todos"))
                .block();
    }

    public Todo getTodoById(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Todo.class)
                .block();
    }

    public int getCount() {
        return getAllTodos().size();
    }
}