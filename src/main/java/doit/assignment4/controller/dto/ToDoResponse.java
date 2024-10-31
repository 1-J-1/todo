package doit.assignment4.controller.dto;

import doit.assignment4.repository.ToDo;
import doit.assignment4.repository.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToDoResponse {

    Long todoId;
    Long userId;
    String content;

    public static ToDoResponse from(ToDo toDo){
        return ToDoResponse.builder()
                .todoId(toDo.getTodoId())
                .userId(toDo.getUserId())
                .content(toDo.getContent())
                .build();
    }
}
