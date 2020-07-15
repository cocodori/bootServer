package org.zerock.tododemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.tododemo.dto.PageRequestDTO;
import org.zerock.tododemo.dto.PageResultDTO;
import org.zerock.tododemo.dto.TodoDTO;
import org.zerock.tododemo.entity.Todo;
import org.zerock.tododemo.repository.TodoRepository;

import java.util.function.Function;
import java.util.stream.IntStream;


@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public Long register(TodoDTO todoDTO) {

        Todo result = todoRepository.save(dtoToEntity(todoDTO));

        return result.getTno();
    }

    @Override
    public PageResultDTO<TodoDTO, Todo> getList(PageRequestDTO pageRequestDTO) {

        Page<Todo> result = todoRepository.findAll(pageRequestDTO.getPageable(Sort.by("tno").descending()));

        Function<Todo, TodoDTO> fn = en -> entityToDTO(en);

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public int makeDummies() {

        IntStream.rangeClosed(1,100).forEach(i -> {
            Todo todo = Todo.builder().text("Text.........." +i).build();
            todoRepository.save(todo);
        });
        return 100;
    }
}










