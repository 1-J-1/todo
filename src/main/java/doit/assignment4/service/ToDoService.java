package doit.assignment4.service;

import doit.assignment4.controller.dto.CheckRequest;
import doit.assignment4.controller.dto.ToDoRequest;
import doit.assignment4.controller.dto.ToDoResponse;
import doit.assignment4.repository.ToDo;
import doit.assignment4.repository.ToDoRepository;
import doit.assignment4.repository.User;
import doit.assignment4.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;

    public ToDoResponse uploadToDo(ToDoRequest request){
        User user = userRepository.findById(request.getUserId()).orElse(null);
        if(user==null){
            throw new IllegalArgumentException("당신은 누구십니까");
        }
        ToDo todo = ToDo.builder()
                .userId(request.getUserId())
                .content(request.getContent())
                .build();

        ToDo saved = toDoRepository.save(todo);
        return ToDoResponse.from(saved);
    }

    public List<ToDo> getToDos(Long userId){
        return toDoRepository.findAllByUserId(userId);
    }

    public void clicked(CheckRequest checkRequest){
        User user = userRepository.findById(checkRequest.getUserId()).orElse(null);
        if(user==null){
            throw new IllegalArgumentException("누굴 말하는겨?");
        }
        ToDo toDo = toDoRepository.findById(checkRequest.getTodoId()).orElse(null);
        if(toDo==null){
            throw new IllegalArgumentException("뭘 하겠다는겨?");
        }
        toDo.setDone(!checkRequest.isDone());
    }
}
