package com.blee.bleespring.controller.api;

import com.blee.bleespring.controller.DTO.BoardDTO;
import com.blee.bleespring.service.BoardService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// @RestController 의 경우 템플릿이 아닌 문자열 그대로 return 함.
@RequestMapping("/board")
public class BoardController {

    @GetMapping("")
    public String getBoard(){
        return "board";
    }
    @Autowired
    BoardService boardService;

    // string return = template file load
    @GetMapping("/")
    public String getBoard(Model model) {
        List<BoardDTO> result = boardService.getBoardAll();
        model.addAttribute("list", result);
        return "board";
    }

    @PostMapping("") // /board
    @ResponseBody // 응답을 주기 위함
    public boolean insertBoard(@RequestBody BoardDTO boardDTO){
        // 2. 게시글 작성
        boardService.insertBoard(boardDTO);
        return true;
    }

    @PatchMapping("") // /board
    @ResponseBody
    public void patchBoard(@RequestBody  BoardDTO boardDTO){
        boardService.patchBoard(boardDTO);
    }

    @DeleteMapping("")
    @ResponseBody
    public void deleteBoard(@RequestParam int id){
        boardService.deleteBoard(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public int searchBoard(@RequestParam String word){
        return boardService.searchBoard(word);
    }

}
