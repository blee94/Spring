package com.blee.bleespring.controller.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDTO {
    private int boardId;
    private String title, content, writer, registered;
    private int no;
}
