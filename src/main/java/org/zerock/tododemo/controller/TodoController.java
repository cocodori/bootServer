package org.zerock.tododemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.tododemo.dto.PageRequestDTO;
import org.zerock.tododemo.dto.PageResultDTO;
import org.zerock.tododemo.dto.TodoDTO;
import org.zerock.tododemo.entity.Todo;
import org.zerock.tododemo.service.TodoService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/todo/")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/makeDummies")
    public Map<String, Integer> makeDummies(){
        Map<String, Integer> result = new HashMap<>();

        result.put("count", todoService.makeDummies() );

        return result;
    }


    @PostMapping("/")
    public Long register(@RequestBody TodoDTO todoDTO){

        log.info(todoDTO);

        Long bno = todoService.register(todoDTO );

        return bno;

    }

    @GetMapping("/list")
    public PageResultDTO<TodoDTO, Todo> list(PageRequestDTO pageRequestDTO){
        log.info("list");
        log.info(pageRequestDTO);

        return todoService.getList(pageRequestDTO);
    }


}
