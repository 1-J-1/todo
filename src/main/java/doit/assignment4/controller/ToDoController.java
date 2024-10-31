package doit.assignment4.controller;

import doit.assignment4.controller.dto.ToDoRequest;
import doit.assignment4.controller.dto.ToDoResponse;
import doit.assignment4.repository.ToDo;
import doit.assignment4.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping("/todo/create")
    public ToDoResponse uploadToDo(@RequestBody ToDoRequest request){
        return toDoService.uploadToDo(request);
    }

    @GetMapping("/todo/{userId}")
    public List<ToDo> getToDos(@PathVariable Long userId){
        return toDoService.getToDos(userId);
    }


}
