package doit.assignment4.controller.dto;

import doit.assignment4.repository.User;
import lombok.Builder;
import lombok.Data;

@Data
public class ToDoRequest {

    Long userId;
    String content;

    @Builder
    public ToDoRequest(Long userId, String content) {
        this.userId = userId;
        this.content = content;
    }
}
