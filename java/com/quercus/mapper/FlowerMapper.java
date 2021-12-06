package com.quercus.mapper;

import com.quercus.pojo.Flower;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FlowerMapper {
    /*查询所有的花卉信息 返回值 List   参数：没有 */
    @Select("select * from flower")
    List<Flower> selectAll();
    /*添加花卉信息*/
    @Insert("insert into flower values (default,#{name},#{price},#{production})")
    int insert(Flower flower);
    /*删除花卉信息*/
    @Delete("delete from flower where id=#{param1}")
    int delete(int id);
    /*查询指定花卉信息*/
    @Select("select * from flower where id=#{param1}")
    Flower selectOne(int id);
    /*修改花卉信息*/
    @Update("update flower set name=#{name},price=#{price},production=#{production} where id=#{id}")
    int update(Flower flower);
}
