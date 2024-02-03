package com.blee.bleespring.controller.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDTO {
    private String id;
    private String title;
    private String writer;
//    private Timestamp written_date;
}
