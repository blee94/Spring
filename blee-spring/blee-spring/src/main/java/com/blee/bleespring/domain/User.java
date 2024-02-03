package com.blee.bleespring.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    private int idx;
    private String id;
    private String title;
    private String writer;
//    private Timestamp written_date;

}