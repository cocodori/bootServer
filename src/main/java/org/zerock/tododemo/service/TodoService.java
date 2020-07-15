package org.zerock.tododemo.service;

import org.zerock.tododemo.dto.PageRequestDTO;
import org.zerock.tododemo.dto.PageResultDTO;
import org.zerock.tododemo.dto.TodoDTO;
import org.zerock.tododemo.entity.Todo;

public interface TodoService {

    Long register(TodoDTO todoDTO);

    PageResultDTO<TodoDTO, Todo> getList(PageRequestDTO pageRequestDTO);

    int makeDummies();

    default Todo dtoToEntity(TodoDTO dto){

        return Todo.builder()
                .tno(dto.getTno())
                .text(dto.getText())
                .build();

    }

    default TodoDTO entityToDTO(Todo entity){

        return TodoDTO.builder()
                .tno(entity.getTno())
                .text(entity.getText())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
    }

}
