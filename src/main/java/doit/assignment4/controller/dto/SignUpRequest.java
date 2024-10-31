package doit.assignment4.controller.dto;

import lombok.Data;

@Data
public class SignUpRequest {

    String email;
    String nickname;
    String password;
}
