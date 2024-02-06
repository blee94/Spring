package com.blee.bleespring.service;


import com.blee.bleespring.controller.DTO.BoardDTO;
import com.blee.bleespring.domain.Board;
import com.blee.bleespring.domain.User;
import com.blee.bleespring.mapper.BoardMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Setter
@Getter
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public List<BoardDTO> getBoardAll(){
        List<Board> result = boardMapper.getBoardAll();
        List<BoardDTO> boards = new ArrayList<>();

        for (Board board  : result){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setBoardId(board.getId());
            boardDTO.setTitle(board.getTitle());
            boardDTO.setWriter(board.getWriter());
            boardDTO.setContent(board.getContent());
            boardDTO.setRegistered(board.getRegistered());
            boardDTO.setNo(100 + board.getId());
            boards.add(boardDTO);
        }
        return boards;
    }

    public boolean insertBoard(BoardDTO boardDTO){
        Board board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setWriter(boardDTO.getWriter());

        boardMapper.insertBoard(board);
        return true;
    }

    public void patchBoard(BoardDTO boardDTO){
        Board board = new Board();
        board.setId(boardDTO.getBoardId());
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setWriter(boardDTO.getWriter());
        boardMapper.patchBoard(board);
    }

    public void deleteBoard(int id){
        boardMapper.deleteBoard(id);
    }

    public int searchBoard(String word){
        List<Board> result = boardMapper.searchBoard(word);
        return result.size();
    }
}
