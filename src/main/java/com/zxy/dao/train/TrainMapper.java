package com.zxy.dao.train;

import com.zxy.entity.train.Train;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TrainMapper {
    List<Train> findAll();

    int deleteByPrimaryKey(String tid);

    int insert(Train record);

    int insertSelective(Train record);

    Train selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKey(Train record);

    List<Train> selectByStopName(String sname);

    void reduceTicket(String tid);

    void addTicket(String tid);

    List<Train> findByTname(String tname);
}