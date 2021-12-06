package com.quercus.service.impl;

import com.quercus.mapper.FlowerMapper;
import com.quercus.pojo.Flower;
import com.quercus.service.FlowerService;
import com.quercus.util.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FlowerServiceImpl implements FlowerService {
    @Override
    public List<Flower> findAll() {
        SqlSession sqlSession = SqlsessionUtil.getSqlSession();
        FlowerMapper mapper = sqlSession.getMapper(FlowerMapper.class);
        List<Flower> flowers = mapper.selectAll();
        sqlSession.close();
        return flowers;
    }

    @Override
    public int save(Flower flower) {
        SqlSession sqlSession = SqlsessionUtil.getSqlSession();
        FlowerMapper mapper = sqlSession.getMapper(FlowerMapper.class);
        int insert = mapper.insert(flower);
        sqlSession.commit();
        sqlSession.close();
        return insert;
    }

    @Override
    public int remove(int id) {
        SqlSession sqlSession = SqlsessionUtil.getSqlSession();
        FlowerMapper mapper = sqlSession.getMapper(FlowerMapper.class);
        int delete = mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        return delete;
    }

    @Override
    public Flower findOne(int id) {
        SqlSession sqlSession = SqlsessionUtil.getSqlSession();
        FlowerMapper mapper = sqlSession.getMapper(FlowerMapper.class);
        Flower flower = mapper.selectOne(id);
        sqlSession.commit();
        sqlSession.close();
        return flower;
    }

    @Override
    public int change(Flower flower) {
        SqlSession sqlSession = SqlsessionUtil.getSqlSession();
        FlowerMapper mapper = sqlSession.getMapper(FlowerMapper.class);
        int update = mapper.update(flower);
        sqlSession.commit();
        sqlSession.close();
        return update;
    }
}
