package com.example.infra.dao.manual;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.infra.po.TaskRecordDO;

@Mapper
public interface TaskRecordManualMapper {

    @Select("select record_id from task_record where task_status in (#{statusList}) and next_exe_time <= #{exeTime} ")
    List<Integer> selectRecordId(List<String> statusList, Date exeTime);

    @Select("select * from task_record where record_id = #{recordId} for update nowait")
    TaskRecordDO lock(Integer recordId);
}
