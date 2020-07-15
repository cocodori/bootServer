package org.zerock.tododemo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.tododemo.entity.Todo;

import java.util.stream.IntStream;

@SpringBootTest
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void insertDummies() {

        IntStream.rangeClosed(1,100).forEach(i -> {
            Todo todo = Todo.builder().text("Text.........." +i).build();
            todoRepository.save(todo);
        });

    }
}
