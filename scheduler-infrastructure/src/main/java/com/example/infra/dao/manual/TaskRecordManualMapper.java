package com.example.infra.dao.manual;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskRecordManualMapper {

    @Select("select record_id from task_record where task_status in (#{statusList}) and next_exe_time <= #{exeTime} ")
    List<Integer> selectRecordId(List<String> statusList, Date exeTime);
}
