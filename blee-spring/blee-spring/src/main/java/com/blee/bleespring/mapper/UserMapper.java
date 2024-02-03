package com.blee.bleespring.mapper;

import com.blee.bleespring.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
// Mapper는 class가 아닌 interface로 정의 되어야 함
public interface UserMapper {
    //    sql 문을 정의 하거나 xml 파일을 읽거나 함

//     xml 파일을 읽는거
    List<User> retrieveAll();

//    @Insert("insert into user(name,nickname) values(#{name}, #{nickname})")
//    void createUser(
//            String name, String nickname);

    @Insert("insert into practice1(id, nickname) values(#{id}, #{nickname})")
    void createUser(
            String id, String nickname);

    @Update("update practice1 set nickname=#{nickname} where id=#{id}")
    void updateUser(
            String id, String nickname);

    @Delete("delete from practice1 where id=#{id}")
    void deleteUser(
            String id);


}
