package doit.assignment4.service;

import doit.assignment4.controller.dto.SignInRequest;
import doit.assignment4.controller.dto.SignInResponse;
import doit.assignment4.controller.dto.SignUpRequest;
import doit.assignment4.repository.User;
import doit.assignment4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void validateUser(String email, String nickname){
        User user1 = userRepository.findByEmail(email);
        if(user1!=null){
            throw new IllegalArgumentException("이미 등록된 메일입니다.");
        }

        User user2 = userRepository.findByNickname(nickname);
        if(user2!=null){
            throw new IllegalArgumentException("이미 등록된 닉네임입니다.");
        }
    }

    public SignInResponse signUp(@RequestBody SignUpRequest request){
        validateUser(request.getEmail(), request.getNickname());
        log.info(request.toString());
        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();
        log.info(user.getEmail());
        User saved = userRepository.save(user);
        return SignInResponse.from(saved);
    }

    public SignInResponse signIn(@RequestBody SignInRequest request){
        User user = userRepository.findByNickname(request.getNickname());
        if(user==null){
            throw new IllegalArgumentException("등록되지 않은 유저입니다.");
        }
        return SignInResponse.from(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
