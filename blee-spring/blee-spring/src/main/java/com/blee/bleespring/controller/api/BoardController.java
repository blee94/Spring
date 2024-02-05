package com.blee.bleespring.controller.api;

import com.blee.bleespring.controller.DTO.BoardDTO;
import com.blee.bleespring.service.BoardService;
import com.blee.bleespring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/")
    public String getMain(){
        return "board";
    }
    @Autowired
    BoardService boardService;

    @GetMapping("/main")
    public List<BoardDTO> getUser(){
        List<BoardDTO> result = boardService.retrieveAll();
        return result;
    }

//    @GetMapping("/insert")
//    public String getBoardInsert(@RequestParam String id, @RequestParam String title, @RequestParam String writer, @RequestParam Timestamp written_date) {
//        boardService.createUser(id, title, writer, written_date);
//        return "Insert Success";
//    }
    @GetMapping("/insert")
    public String getBoardInsert(@RequestParam String id, @RequestParam String title, @RequestParam String writer) {
        boardService.createUser(id, title, writer);
        return "Insert Success";
    }
    @GetMapping("/update")
    public String getBoardUpdate(@RequestParam String id, @RequestParam String writer) {
        boardService.updateUser(id, writer);
        return "Update Success";
    }
    @GetMapping("/delete")
    public String getBoardDelete(@RequestParam String id) {
        boardService.deleteUser(id);
        return "Delete Success";
    }
}
