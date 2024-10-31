package doit.assignment4.controller.dto;

import lombok.Data;

@Data
public class CheckRequest {

    Long userId;
    Long todoId;
    boolean done;
}
