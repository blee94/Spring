package com.blee.bleespring.mapper;

import com.blee.bleespring.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BoardMapper {

    List<User> retrieveAll();

//    @Insert("insert into practice2(id, title, writer, written_date) values(#{id}, #{title}, #{writer}, #{written_date})")
//    void createUser(
//            String id, String title, String writer, Timestamp written_date);
    @Insert("insert into practice2(id, title, writer) values(#{id}, #{title}, #{writer})")
    void createUser(
            String id, String title, String writer);

    @Update("update practice2 set writer=#{writer} where id=#{id}")
    void updateUser(
            String id, String writer
    );

    @Delete("delete from practice2 where id=#{id}")
    void deleteUser(
            String id
    );

}
