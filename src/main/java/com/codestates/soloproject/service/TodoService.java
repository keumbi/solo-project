package com.codestates.soloproject.service;

import com.codestates.soloproject.dto.TodoRequestDto;
import com.codestates.soloproject.entity.Todo;
import com.codestates.soloproject.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    // 할 일 목록을 등록할 수 있어야 합니다.
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // 등록된 전체 할 일 목록을 조회할 수 있어야 합니다.
    public List<Todo> findTodos() {
        List<Todo> todoLists = todoRepository.findAll();
        return todoLists;
    }

    // 등록되어있는 할 일의 특정 id를 입력하여 조회할 수 있어야 합니다.
    public Todo findTodo(Long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        Todo todo = optionalTodo.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        return todo;

    }
    // 이미 한 일에는 완료 표시를 할 수 있어야 합니다.
    // 할 일의 내용을 수정할 수 있어야 합니다.
    public Todo updateTodo(Long todoId, TodoRequestDto requestDto) {
        Todo findTodo = findTodo(todoId);

        Optional.ofNullable(requestDto.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));

        Optional.ofNullable(requestDto.getOrder())
                .ifPresent(order -> findTodo.setOrder(order));

        Optional.ofNullable(requestDto.getCompleted())
                .ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }
    // 등록된 전체 할 일을 삭제할 수 있어야 합니다.
    public void deleteAll() {
        todoRepository.deleteAll();
    }

    // 등록되어있는 할 일의 특정 id를 입력하여 삭제할 수 있어야 합니다.
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

}
