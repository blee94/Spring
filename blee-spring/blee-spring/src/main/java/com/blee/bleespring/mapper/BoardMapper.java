package com.blee.bleespring.mapper;

import com.blee.bleespring.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getBoardAll(); // 전체 조회 ( select * from board; )
    // resource/ mybatis-mapper 에 생성한 BoardMapper에 getBoardAll을 작성했음.

    void insertBoard(Board board); // 삽입(insert)

    void patchBoard(Board board); // 수정(update)

    void deleteBoard(int id); // 삭제(delete)

    List<Board> searchBoard(String word);


    // sql 을 작성하거나, xml 파일을 작성하거나.
    // 1) mapper 에는 메소드가 있고, xml 에는 없는경우 -> 실행했을 때 오류.

//    @Insert("insert into board(id, title, writer, content, registered) values(#{id}, #{title}, #{writer}, #{content}, #{registered})")
//    void createUser(
//            String id, String title, String writer, String content, String registered);
//
//    @Update("update board set writer=#{writer} where id=#{id}")
//    void updateUser(
//            String id, String writer
//    );
//
//    @Delete("delete from board where id=#{id}")
//    void deleteUser(
//            String id
//    );

}
