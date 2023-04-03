package com.example.infra.dao.manual;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.infra.po.TaskRecordDO;

@Mapper
public interface TaskRecordManualMapper {

    @Select("select record_id from task_record where task_status in (#{statusList}) and next_exe_time <= #{exeTime} limit #{limit}")
    List<Integer> selectRecordIds(@Param("statusList") List<String> statusList, @Param("exeTime") Date exeTime, @Param("limit") int limit);

    @Select("select * from task_record where record_id = #{recordId} for update nowait")
    TaskRecordDO lock(@Param("recordId") Integer recordId);

    @Update("update task_record set task_status = #{targetStatus} where record_id = #{recordId} and task_status = #{previousStatus}")
    int optimisticLockByTaskStats(@Param("recordId") Integer recordId, @Param("previousStatus") String previousStatus, @Param("targetStatus") String targetStatus);
}
