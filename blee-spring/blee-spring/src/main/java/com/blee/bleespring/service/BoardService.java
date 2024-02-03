package com.blee.bleespring.service;


import com.blee.bleespring.controller.DTO.BoardDTO;
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

    public List<BoardDTO> retrieveAll(){

        List<User> users = boardMapper.retrieveAll();
        List<BoardDTO> result = new ArrayList<>();

        for (User practice2 : users){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setId(practice2.getId());
            boardDTO.setTitle(practice2.getTitle());
            boardDTO.setWriter(practice2.getWriter());
//            boardDTO.setWritten_date(practice2.getWritten_date());

            result.add(boardDTO);
        }
        return result;
    }

//    public void createUser(String id, String title, String writer, Timestamp written_date)
//    { boardMapper.createUser(id, title, writer, written_date);
//    }
    public void createUser(String id, String title, String writer)
    { boardMapper.createUser(id, title, writer);
    }
    public void updateUser(String id, String writer)
    { boardMapper.updateUser(id, writer);
    }
    public void deleteUser(String id)
    { boardMapper.deleteUser(id);
    }

}
