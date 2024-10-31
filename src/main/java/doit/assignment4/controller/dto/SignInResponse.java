package doit.assignment4.controller.dto;

import doit.assignment4.repository.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInResponse {

    Long id;
    String nickname;

    public static SignInResponse from(User user){
        return SignInResponse.builder()
                .id(user.getUserId())
                .nickname(user.getNickname())
                .build();
    }
}
