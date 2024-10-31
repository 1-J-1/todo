package doit.assignment4.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ToDo {

    @Id
    @Column(name = "todo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long todoId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    Long userId;
    String content;
    Boolean done;

    @Builder
    public ToDo(Long userId, String content) {
        this.userId = userId;
        this.content = content;
        this.done = false;
    }
}
