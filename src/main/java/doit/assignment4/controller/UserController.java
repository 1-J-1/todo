package doit.assignment4.controller;

import doit.assignment4.controller.dto.SignInRequest;
import doit.assignment4.controller.dto.SignInResponse;
import doit.assignment4.controller.dto.SignUpRequest;
import doit.assignment4.repository.User;
import doit.assignment4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/sign-up")
    public SignInResponse signUp(@RequestBody SignUpRequest request){
        return userService.signUp(request);
    }

    @PostMapping("/user/sign-in")
    public SignInResponse signIn(@RequestBody SignInRequest request){
        return userService.signIn(request);
    }

    @GetMapping("/user")
    public List<User> findAll(){
        return userService.findAll();
    }
}
