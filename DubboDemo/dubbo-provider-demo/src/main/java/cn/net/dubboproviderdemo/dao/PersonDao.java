package cn.net.dubboproviderdemo.dao;


import cn.net.dubboproviderdemo.model.Person;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PersonDao {

    @Select(value = "select * from user where id = #{id}")
    Person findPersonById(int id);

    @Insert(value = "insert into user(id,username,age,sex) values(#{id},#{username},#{age},#{sex})")
    void addPerson(Person person);

    @Update(value = "update user set username = #{username}, age = #{age}, sex = #{sex} where id = #{id}")
    void updatePersonById(Person person);

    @Delete(value = "delete from user where id = #{id}")
    void deletePersonById(int id);


}
