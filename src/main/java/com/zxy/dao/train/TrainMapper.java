package com.zxy.dao.train;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.entity.stop.Stop;
import com.zxy.entity.train.Train;
import com.zxy.model.backstage.QueryTrainDetailResultForm;
import com.zxy.model.backstage.QueryTrainListResultForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    List<QueryTrainListResultForm> findByArriveTime(@Param("tTime") Date tTime, Page page);

    QueryTrainDetailResultForm trainDetail(String id);
}