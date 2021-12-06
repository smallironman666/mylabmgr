package com.quercus.service;

import com.quercus.pojo.Flower;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FlowerService {
    /*查询所有花卉信息*/
    List<Flower> findAll();
    /*添加花卉信息*/
    int save(Flower flower);
    /*删除花卉信息*/
    int remove(int id);
    /*查询指定花卉信息*/
    Flower findOne(int id);
    /*修改花卉的信息*/
    int change(Flower flower);
}
