package com.codestates.soloproject.controller;

import com.codestates.soloproject.dto.TodoRequestDto;
import com.codestates.soloproject.entity.Todo;
import com.codestates.soloproject.mapper.TodoMapper;
import com.codestates.soloproject.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@CrossOrigin("https://todobackend.com")
@RestController
//@RequestMapping("/")
@RequiredArgsConstructor
//@Validated
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;


    @PostMapping
    public ResponseEntity postTodo(@RequestBody TodoRequestDto requestDto) {
        //log.info("CREATED");
        Todo createTodo = todoService.createTodo(todoMapper.todoRequestDtoToTodo(requestDto));

        return new ResponseEntity<>(todoMapper.todoToTodoResponseDto(createTodo), HttpStatus.CREATED);
    }

    /*@GetMapping
    public ResponseEntity getTodos() {
        //log.info("GET_TODOS");
        List<Todo> todoLists = todoService.findTodos();
        return new ResponseEntity<>(todoMapper.todosToTodoResponses(todoLists), HttpStatus.OK);
    }*/
    @GetMapping
    public String getTodos() {
        return "Todo Application!!";
    }
    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") Long todoId) {
        log.info("GET_TODO");
        Todo todoList = todoService.findTodo(todoId);
        return new ResponseEntity<>(todoMapper.todoToTodoResponseDto(todoList), HttpStatus.OK);
    }

    @PatchMapping("{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") Long todoId, @RequestBody TodoRequestDto requestDto) {
        Todo updateTodo = todoService.updateTodo(todoId, requestDto);

        return new ResponseEntity<>(todoMapper.todoToTodoResponseDto(updateTodo), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity deleteAll() {
        log.info("DELETE_ALL");
        todoService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") Long todoId) {
        todoService.deleteTodo(todoId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
