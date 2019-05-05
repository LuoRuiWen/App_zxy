package com.zxy.dao.train;

import com.zxy.entity.train.Train;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TrainMapper {
    List<Train> findAll();

    int deleteByPrimaryKey(Integer tid);

    int insert(Train record);

    int insertSelective(Train record);

    Train selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKey(Train record);

    List<Train> selectByStopName(String sname);

    void reduceTicket(Integer tid);

    void addTicket(Integer tid);

    List<Train> findByTname(String tname);
}